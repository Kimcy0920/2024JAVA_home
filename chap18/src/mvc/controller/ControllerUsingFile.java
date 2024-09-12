package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingFile extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>(); // HashMap <Key, Value>

    public void init() throws ServletException { // 초기에 실행되는 코드
    	/*  
    	   getInitParameter는 web.xml에서
    	   <param-name>configFile</param-name>
    	   <param-value>/WEB-INF/commandHandler.properties</param-value>
    	   
    	   commandHandler.properties 코드-> hello=mvc.hello.HelloHandler
    	   hello 핸들러(객체)
    	*/
        String configFile = getInitParameter("configFile");
        Properties prop = new Properties();
        String configFilePath = getServletContext().getRealPath(configFile);
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        Iterator keyIter = prop.keySet().iterator(); // properties를 하나씩 꺼냄
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            try {
                Class<?> handlerClass = Class.forName(handlerClassName); // 객체 생성 --
                CommandHandler handlerInstance = 
                        (CommandHandler) handlerClass.newInstance(); // -- 객체 생성
                commandHandlerMap.put(command, handlerInstance); // HaspMap에 넣음
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    // req와 res 객체를 받아 핸들러 호출하고 결과를 jsp페이지로 포워딩
    private void process(HttpServletRequest request, // process 인터페이스
    HttpServletResponse response) throws ServletException, IOException {
    	// 요청 파라미터에서 'cmd' 값을 가져옴
    	String command = request.getParameter("cmd");
    	// 'command' 값에 해당하는 핸들러를 commandHandlerMap에서 찾음
        CommandHandler handler = commandHandlerMap.get(command);
        // 핸들러가 없는 경우 NullHandler를 기본 핸들러로 설정
        if (handler == null) {
            handler = new NullHandler();
        }
        String viewPage = null;
        try {
        	// 핸들러의 process 메서드를 호출하여 결과로 뷰 페이지 경로를 얻음
            viewPage = handler.process(request, response);
            // process 인터페이스
        } catch (Throwable e) {
        	// 처리 중 발생한 예외를 ServletException으로 감싸서 재발생
            throw new ServletException(e);
        }
        // 뷰 페이지 경로가 null이 아닌 경우, RequestDispatcher를 통해 포워딩
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}

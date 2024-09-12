package mvc.simple;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 곳에 요청명 코드가 없으면 web.xml에 코드가 존재한다는 것, 요청명: /simple
public class SimpleController extends HttpServlet { // C, 컨트롤러

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response); // doGet에서 processRequest 실행
	}

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response); // doPost에서 processRequest 실행
	}
	
	// Get, Post 둘다 이 코드를 실행함
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException {
		// 2단계, 요청 파악
		// request 객체로부터 사용자의 요청을 파악하는 코드
		String type = request.getParameter("type");
		
		// 3단계, 요청한 기능을 수행한다.
		// 사용자에 요청에 따라 알맞은 코드
		Object resultObject = null; // 모든 클래스의 부모격인 오브젝트, 문자열처럼 사용
		if (type == null || type.equals("greeting")) { // 타입이 null이거나 greeting일 경우
			resultObject = "안녕하세요.";
		} else if (type.equals("date")) { // 타입이 date일 경우
			resultObject = new java.util.Date(); // 날짜정보
		} else {
			resultObject = "Invalid Type";
		}
		// 주소창 localhost:8080/chap18/simple?type=
		
		// 4단계, request나 session에 처리 결과를 저장
		request.setAttribute("result", resultObject); // 포워딩 전에 저장
		
		// 5단계, RequestDispatcher를 사용하여 알맞은 뷰로 포워딩
		RequestDispatcher dispatcher =
				   request.getRequestDispatcher("/simpleView.jsp"); // V, View
		dispatcher.forward(request, response);
	}
}

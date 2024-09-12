package board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ReplyArticleService;
import mvjsp.chap17.board.service.ReplyingRequest;

public class ErrorHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		try {
            // 예외가 발생할 가능성이 있는 코드 (예: 데이터 처리 로직)
			return "/WEB-INF/view/list.jsp";
        } catch (Exception exception) {
            exception.printStackTrace();
            // 예외가 발생하면 해당 예외를 로그로 출력하고 list.jsp로 이동
            return "/WEB-INF/view/list.jsp";
        }
	}

}

package board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.IdGenerationFailedException;
import mvjsp.chap17.board.service.WriteArticleService;
import mvjsp.chap17.board.service.WritingRequest;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String writerName = req.getParameter("writerName");
		String title = req.getParameter("title");
		String password = req.getParameter("password");
		String content = req.getParameter("content");
		WritingRequest writingRequest = new WritingRequest(writerName, password, title, content);
		Article postedArticle = null;
		try {
			postedArticle = WriteArticleService.getInstance().write(writingRequest);
		} catch (IdGenerationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("postedArticle", postedArticle);
		return "/WEB-INF/view/writeResult.jsp";
	}

}

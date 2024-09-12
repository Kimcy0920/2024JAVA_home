package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ReplyArticleService;
import mvjsp.chap17.board.service.ReplyingRequest;

public class ReplyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("euc-kr");
			
			String writerName = req.getParameter("writerName");
			String title = req.getParameter("title");
			String password = req.getParameter("password");
			String content = req.getParameter("content");
			int parentArticleId = Integer.parseInt(req.getParameter("parentId"));
			String p = req.getParameter("p");		
			
			System.out.println("parentId 파라미터: " + req.getParameter("parentId"));
			
			ReplyingRequest replyingRequest = new ReplyingRequest(writerName, password, title, content, parentArticleId, p);
			
			Article postedArticle = ReplyArticleService.getInstance().
					reply(replyingRequest);
			req.setAttribute("postedArticle", postedArticle);
			return "/WEB-INF/view//reply_success.jsp";
			
		} catch(Exception ex) {
			
			req.setAttribute("replyException", ex);
			return "/WEB-INF/view/reply_error.jsp";
		}
	}

}

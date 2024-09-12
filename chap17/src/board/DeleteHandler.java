package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.service.DeleteArticleService;
import mvjsp.chap17.board.service.DeleteRequest;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("euc-kr");
			
			int articleId = Integer.parseInt(req.getParameter("articleId"));
			String password = req.getParameter("password");
			DeleteRequest deleteRequest = new DeleteRequest(articleId, password);
			
			DeleteArticleService.getInstance().deleteArticle(deleteRequest);
			return "/delete_success.jsp";
			
		} catch (Exception ex) {
			
			req.setAttribute("deleteException", ex);
			return "/delete_error.jsp";
		}
	}

}

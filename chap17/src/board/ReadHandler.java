package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ArticleNotFoundException;
import mvjsp.chap17.board.service.ReadArticleService;

public class ReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int articleId = Integer.parseInt(req.getParameter("articleId"));
		
		try {
			Article article = ReadArticleService.getInsteance().readArticle(articleId);
			req.setAttribute("article", article);
			return "/WEB-INF/view/read_view.jsp";
			
		} catch(ArticleNotFoundException ex) {
			
			return "/Web-INF/view/article_not_found.jsp";
		}
		
	}
		
}

package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private Gson gson = new Gson();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (pathInfo == null || pathInfo.equals("/")) {
			out.print(gson.toJson(DatabaseUtil.getAllBoard()));
		} else {
            try {
                int num = Integer.parseInt(pathInfo.substring(1));
                Optional<Board> board = DatabaseUtil.getBoardByNum(num);
                if (board.isPresent()) {
                    out.print(gson.toJson(board.get()));
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"message\":\"Item not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"message\":\"Invalid item ID\"}");
            }
        }
        out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package shop;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shop/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        if (cart == null) { // 카트가 널이면
            cart = new HashMap<>(); // 해시맵 생성
        }

        request.setCharacterEncoding("UTF-8"); // 한글 처리
        String product = request.getParameter("product"); // 제품명 받음
        int price = Integer.parseInt(request.getParameter("price")); // 가격 받음

        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }
}
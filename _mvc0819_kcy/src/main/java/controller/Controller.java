package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.BoardDAO;
import board.BoardDTO;
import file.FileDAO;
import file.FileDTO;
import mem.memDAO;
import mem.memDTO;
import service.Service;
import shop.CartDAO;
import shop.Product;
import shop.ProductDAO;

@WebServlet("/")
public class Controller extends HttpServlet {
	// 시작위치, 모든 요청은 컨트롤러에서 받아서 처리함
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String view = null;
		HttpSession session = request.getSession();

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

//---------------------------------MEMBER CONTROLLER------------------------------

		// 메인 화면 동작
		if (com.equals("/main") || (com.equals("/"))) {
			request.setCharacterEncoding("utf-8");
			view = "main.jsp";

		// 로그인 동작 수행
		} else if (com.equals("/login_view")) {
			view = "login_form.jsp";

		} else if (com.equals("/login_form")) {

			request.setCharacterEncoding("utf-8");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			memDAO mdao = new memDAO();
			memDTO mdto = mdao.memLogin(new memDTO(id, pw, "", ""));

			if (mdto != null) {
				session.setAttribute("id", mdto.getId());
				session.setAttribute("pw", mdto.getPw());
				session.setAttribute("name", mdto.getName());
				session.setAttribute("tel", mdto.getTel());
				
				view = "redirect:main";
			} else {
				out.println("<script>alert('잘못된 아이디 또는 비밀번호입니다.'); history.back(); </script>");
				out.close();
				view = "redirect:login_form";
			}

		// 로그아웃
		} else if (com.equals("/logout")) {
			session.invalidate();
			view = "redirect:main";

		// 로그인 안내
		} else if (com.equals("/login_notice")) {
			out.println("<script>alert('로그인 후 이용이 가능합니다.'); location.href='login_view'; </script>");

		// 회원정보 수정
		} else if (com.equals("/mem_update_view")) {
			view = "mem_update_form.jsp";

		} else if (com.equals("/mem_update_form")) {
			request.setCharacterEncoding("utf-8");
			String id = (String) session.getAttribute("id");
			String pw = (String) session.getAttribute("pw");
			String name = (String) session.getAttribute("name");
			String tel = (String) session.getAttribute("tel");
			
			String m_pw = request.getParameter("pw");
			String m_name = request.getParameter("name");
			String m_tel = request.getParameter("tel");

			memDAO dao = new memDAO();
			dao.memUpdate(new memDTO(id, m_pw, m_name, m_tel));
			out.println("<script>alert('수정이 완료되었습니다.'); location.href='login_view'; </script>");

		// 회원정보 삭제
		} else if (com.equals("/mem_delete")) {
			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");

			BoardDAO bdao = new BoardDAO();
			bdao.deleteWriter(name);

			memDAO dao = new memDAO();
			dao.memDelete(id);

			session.invalidate();
			out.println("<script>alert('회원 탈퇴되었습니다.'); location.href='login_view'; </script>");

		// 회원가입
		} else if (com.equals("/signup_view")) {
			view = "signup_form.jsp";

		} else if (com.equals("/signup_form")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");

			memDAO dao = new memDAO();
			memDTO dto = dao.memCheck(id);
			memDTO dto2 = new memDTO(id, pw, name, tel);

			if (dto != null) {
				out.println("<script>alert('이미 등록된 아이디입니다.'); history.back(); </script>");
				out.close();
			} else {
				dao.memSignup(dto2);
				out.println("<script>alert('가입이 완료되었습니다.'); location.href='login_view'; </script>");
			}
		}

//---------------------------------BOARD CONTROLLER------------------------------

		// 게시판 글 리스트
		else if (com.equals("/list")) {
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;

			request.setAttribute("msgList", new Service().getMsgList(pageNo));
			request.setAttribute("pgnList", new Service().getPagination(pageNo));
			view = "/list.jsp";

		// 게시판 글 보기
		} else if (com.equals("/view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			String name = (String) session.getAttribute("name");

			request.setAttribute("msg", new Service().getMsg(num));
			view = "/view.jsp";

		// 게시판 글 작성
		} else if (com.equals("/write")) {
			String tmp = request.getParameter("num");
			String id = (String) session.getAttribute("id");

			int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

			BoardDTO dto = new BoardDTO();
			String action = "insert";

			if (num > 0) {
				dto = new Service().getMsgForWrite(num);
				action = "update?num=" + num;
			}

			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "/write.jsp";

		} else if (com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String regtime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);

			try {
				new Service().writeMsg(writer, title, content, regtime);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "/errorBack.jsp";
			}

		// 게시판 글 수정
		} else if (com.equals("/update")) {
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			try {
				new Service().updateMsg(writer, title, content, num);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "/errorBack.jsp";
			}

		// 게시판 글 삭제
		} else if (com.equals("/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));

			new Service().deleteMsg(num);
			view = "redirect:list";
		}

//---------------------------------FILE CONTROLLER------------------------------

		// 자료실 화면
		else if (com.equals("/webhard")) {
			FileDAO fdao = new FileDAO();
			request.setAttribute("list", fdao.getAllwebhard());
			view = "/webhard.jsp";

		// 파일 선택 및 업로드
		} else if (com.equals("/add_file")) {

			MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/files"),
					100 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

			File file = multi.getFile("upload");

			if (file != null) {
				String curTime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);

				FileDAO dao = new FileDAO();
				FileDTO dto = new FileDTO(0, file.getName(), curTime, (int) file.length());
				dao.insertFile(dto);

				// 메인 페이지로 돌아가기
				view = "redirect:webhard";
			} else {
				out.println("<script>alert('파일을 선택해주세요.'); location.href='webhard'; </script>");
			}

		// 파일 삭제
		} else if (com.equals("/del_file")) {
			int num = Integer.parseInt(request.getParameter("num"));
			FileDAO dao = new FileDAO();
			FileDTO dto = dao.getFileByNum(num);

			if (dto != null) {
				// 지정된 파일 삭제
				File file = new File(request.getServletContext().getRealPath("/files/") + dto.getFname());
				if (file != null) {
					file.delete();
				}
				dao.deleteFile(num);
			}
			view = "redirect:webhard";
		}

//---------------------------------PRODUCT CONTROLLER------------------------------

		// 물품 목록 리스트
		else if (com.equals("/productList")) {
			ProductDAO pdao = new ProductDAO();
			List<Product> products = pdao.getAllProducts();
			request.setAttribute("products", products);
			view = "productList.jsp";

		// 물품 등록
		} else if (com.equals("/registProduct")) {
			view = "registProduct.jsp";

		} else if (com.equals("/insertProduct")) {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			Product product = new Product(0, name, description, Double.parseDouble(price), Integer.parseInt(stock));
			ProductDAO productDAO = new ProductDAO();
			productDAO.addProduct(product);

			view = "redirect:productList";

		} else if (com.equals("/modifyProduct")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");

			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.getProductById(Integer.parseInt(id));
			request.setAttribute("product", product);

			view = "modifyProduct.jsp";

		// 물품 정보 수정
		} else if (com.equals("/updateProduct")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			Product product = new Product(Integer.parseInt(id), name, description, Double.parseDouble(price),
					Integer.parseInt(stock));
			ProductDAO productDAO = new ProductDAO();
			productDAO.updateProduct(product);

			view = "redirect:productList";

		// 물품 삭제
		} else if (com.equals("/deleteProduct")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");

			ProductDAO productDAO = new ProductDAO();
			boolean ret = productDAO.deleteProduct(Integer.parseInt(id));
			request.setAttribute("flag", ret);

			view = "redirect:productList";
		}

//---------------------------------CART CONTROLLER------------------------------

		// 장바구니 목록
		else if (com.equals("/viewCart")) {
			CartDAO dao = new CartDAO();
			request.setAttribute("list", dao.viewCart());

			view = "viewCart.jsp";

		// 장바구니에 저장
		} else if (com.equals("/addToCart")) {
			String id = request.getParameter("id");
			CartDAO dao = new CartDAO();
			ProductDAO pdao = new ProductDAO();

			if (pdao.countProducts(Integer.parseInt(id)) <= 0) {
				out.println("<script>alert('장바구니에 담을 수량이 부족합니다.'); history.back(); </script>");
				request.setAttribute("flag", true);
			} else {
				pdao.decreaseStock(Integer.parseInt(id));
				dao.addToCart(Integer.parseInt(id));
			}
			request.setAttribute("list", dao.viewCart());

		// 장바구니 항목 삭제
		} else if (com.equals("/deleteCart")) {
			String id = request.getParameter("id");
			CartDAO dao = new CartDAO();
			dao.deleteProduct(Integer.parseInt(id));

			view = "redirect:viewCart";
		}

		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
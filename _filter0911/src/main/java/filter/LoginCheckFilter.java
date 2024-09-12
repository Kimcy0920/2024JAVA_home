package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@WebFilter("/LoginCheckFilter")
public class LoginCheckFilter extends HttpFilter implements Filter {
	
    public LoginCheckFilter() {
        super();

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		// 세션 가져오기
		
		System.out.println("필터에 들어옴");
		boolean login = false; // 기본은 false
		if (session != null) {
			if(session.getAttribute("MEMBER") != null) {
				login = true;
				// 세션이 null이 아니면 MEMBER세션을 가져오고, MEMBER세션이 null이 아니면 로그인 true
			}
		}
		if (login) {
			System.out.println("필터를 통과함"); // login이 true면 필터 통과
			chain.doFilter(request, response);
		} else { // 로그인 실패. loginForm으로 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

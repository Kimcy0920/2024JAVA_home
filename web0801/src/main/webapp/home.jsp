<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    Cookie[] cookies = request.getCookies();
    String name = null;
	boolean flag = false;
	
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                name = cookie.getValue();
                flag = true;
                break;
            }
        }
    }
    
if (flag) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>
<%
response.sendRedirect("/web0802/board/list.jsp");
%>
</body>
</html>
<%
} else {
	out.println("<script type='text/javascript'>");
	out.println("alert('로그인 후 접속이 가능합니다.')");
	out.println("window.location.href = 'login.jsp';");
	out.println("</script>");
}
%>
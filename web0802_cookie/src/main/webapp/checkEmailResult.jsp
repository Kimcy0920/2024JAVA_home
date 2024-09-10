<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rememberMe = request.getParameter("rememberMe");
String email = request.getParameter("email");
System.out.println(rememberMe); // 체크하면 on / 체크풀면 null
if ("on".equals(rememberMe)) {
	response.addCookie(Cookies.createCookie("email", email, "/", -1));
} else {
	response.addCookie(Cookies.createCookie("email", email, "/", 0));
}
response.sendRedirect("checkEmail.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
이메일을 쿠키에 저장하였습니다.
</body>
</html>
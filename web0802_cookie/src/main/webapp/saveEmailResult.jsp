<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
response.sendRedirect("saveEmail.jsp");
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
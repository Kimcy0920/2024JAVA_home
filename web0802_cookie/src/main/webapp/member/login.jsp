<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if (id.equals(password)) {
	response.addCookie(
		Cookies.createCookie("AUTH", id, "/", -1)); // (-1: 이전페이지로)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
로그인에 성공했습니다.
</body>
</html>
<%
} else {
%>
<script>
alert("로그인에 실패하였습니다.");
history.go(-1);
</script>
<%
}
%>
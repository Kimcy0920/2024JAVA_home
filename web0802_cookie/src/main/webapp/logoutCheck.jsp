<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.addCookie(
			Cookies.createCookie("AUTH", "", "/", 0)
	);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logoutCheck</title>
</head>
<body>
로그아웃하였습니다.
</body>
</html>
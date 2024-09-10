<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// request.getParameter과 유사함
String str = (String) session.getAttribute("key1");
List<String> list = (List<String>) session.getAttribute("key2");
// 쿠키는 문자열만 가능한데 세션은 문자열 객체 ArrayList 다 가능함
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=str %></h1>
<h1><%=list %></h1>
</body>
</html>
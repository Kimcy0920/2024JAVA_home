<%@page import="java.util.Arrays"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// set으로 세션에 저장
session.setAttribute("key1", "김수열 줄넘기");
session.setAttribute("key2", Arrays.asList("역시", "앙!"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션 저장</h1>
</body>
</html>
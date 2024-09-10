<%@page import="board.BdDTO"%>
<%@page import="board.BdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");

BdDAO dao = new BdDAO();
dao.deleteBoard(Integer.parseInt(num));
response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
</body>
</html>
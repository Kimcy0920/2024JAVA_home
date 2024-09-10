<%@page import="board.BdDTO"%>
<%@page import="board.BdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

BdDAO dao = new BdDAO();
BdDTO dto = new BdDTO(0, writer, title, content, "", 0);
dao.insertBoard(dto);
response.sendRedirect("list.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
</body>
</html>
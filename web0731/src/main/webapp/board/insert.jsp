<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDAO dao = new BoardDAO();
dao.insertBoard(writer, title, content);
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
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String num = request.getParameter("num");

BoardDAO dao = new BoardDAO();
dao.updataBoard(writer, title, content, (Integer.parseInt(num)));
response.sendRedirect("list.jsp");
%>
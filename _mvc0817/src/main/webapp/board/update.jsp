<%@page import="board.BdDTO"%>
<%@page import="board.BdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String num = request.getParameter("num");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

BdDAO dao = new BdDAO();
BdDTO dto = new BdDTO(Integer.parseInt(num), writer, title, content, "", 0);
dao.updateBoard(dto);
response.sendRedirect("list.jsp");
%>
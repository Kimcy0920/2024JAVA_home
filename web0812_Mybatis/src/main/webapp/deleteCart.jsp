<%@page import="shop.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
CartDAO dao = new CartDAO();
dao.deleteProduct(Integer.parseInt(id));
%>
<jsp:forward page="viewCart.jsp"/>
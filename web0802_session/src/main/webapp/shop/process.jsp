<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart"); // 해시맵 통째로 꺼냄

if (cart == null) { // 카트(해시맵)가 널이면
    cart = new HashMap<>(); // 해시맵 생성
}

request.setCharacterEncoding("UTF-8"); // 한글 처리
String product = request.getParameter("product"); // 제품명 받음
// int price = Integer.parseInt(request.getParameter("price")); // 가격 받음

if (cart.containsKey(product)) {
    cart.put(product, cart.get(product) + 1);
} else {
    cart.put(product, 1);
}

session.setAttribute("cart", cart);
response.sendRedirect("cart.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
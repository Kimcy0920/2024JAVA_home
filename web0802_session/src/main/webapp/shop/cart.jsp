<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>쇼핑 카트</title>
</head>
<body>
    <h1>나의 카트</h1>
    <%
    		//  상품명     개수
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart"); // 세션에서 카트 키 가져오기
        if (cart == null || cart.isEmpty()) { // 카트 처음상태
            out.println("<p>카트가 비어 있습니다.</p>");
        } else {
            out.println("<ul>");
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                out.println("<li>" + entry.getKey() + " - 수량: " + entry.getValue() + "</li>");
            }
            out.println("</ul>");
        }
    %>
    <a href="products.jsp">쇼핑 계속하기</a>
</body>
</html>
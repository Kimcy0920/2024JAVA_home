<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// HashMap과 유사함
Cookie cookie = new Cookie("username", "신짱구"); // key , value로 쿠키생성
response.addCookie(cookie); // 쿠키저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>makeCookie</title>
</head>
<body>
<%=cookie.getName() %>: <%=cookie.getValue() %> <!-- 쿠키출력 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyCookie</title>
</head>
<body>
<%
// 코드를 위에 작성하는 경우: html 문서랑 상관없을 때 / 코드를 본문에 작성하는 경우: html 문서와 연관있을 때

// 쿠키의 정보는 여러 개일 수 있어 배열로 다 받음
Cookie[] cookies = request.getCookies();
if (cookies != null && cookies.length > 0) {
// 쿠키가 null이 아니고, 갯수가 0이 아닌 경우
	for (int i=0; i<cookies.length; i++) {
		if (cookies[i].getName().equals("username")) {
			Cookie cookie = new Cookie("username", "신짱구");
			response.addCookie(cookie);
		}
	}
}
%>
<h1>LoginId 쿠키 변경</h1>
</body>
</html>
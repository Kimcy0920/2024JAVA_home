<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewCookies</title>
</head>
<body>
<%
// 코드를 위에 작성하는 경우: html 문서랑 상관없을 때 / 코드를 본문에 작성하는 경우: html 문서와 연관있을 때

// 쿠키의 정보는 여러 개일 수 있음. 배열로 받음
Cookie[] cookies = request.getCookies();
if (cookies != null && cookies.length > 0) {
// 쿠키가 null이 아니고, 갯수가 0이 아닌 경우
	for (int i=0; i<cookies.length; i++) {
		out.println(cookies[i].getName() + ": " + cookies[i].getValue());
	}
}
%>
</body>
</html>
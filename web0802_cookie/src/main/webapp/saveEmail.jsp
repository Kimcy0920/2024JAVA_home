<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookies cookies = new Cookies(request); // util.Cookies의 getValue사용
String email = cookies.getValue("email"); // 문자열 email에 쿠키에 저장된 "email"을 넣음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일을 쿠키에 저장</title>
</head>
<body>
<form action="saveEmailResult.jsp" method="post">
	<label for="email">Email:</label>
	<input type="email" id="email" name="email" value="<%=email %>" required>
	<input type="submit" value="저장">

</form>
</body>
</html>
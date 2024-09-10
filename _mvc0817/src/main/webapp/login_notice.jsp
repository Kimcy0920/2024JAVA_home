<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내</title>
</head>
<body>
<%
	if ((String)session.getAttribute("userId") == null) {
%>
<script>
	alert('로그인 후 이용이 가능합니다.');
	window.location.href='login_form.jsp';
</script>
<%
	}
%>
</body>
</html>
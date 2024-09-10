<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
%>
<html>
<head><title>이메일 저장 여부</title></head>
<body>

<%
	if (cookies.exists("email")) {
%>
Email: "<%= cookies.getValue("email") %>"
<%
	} else {
%>
Email 저장 실패
<%
	}
%>
</body>
</html>
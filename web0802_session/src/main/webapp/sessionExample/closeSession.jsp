<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// session.invalidate(); // 모든 세션 삭제
session.removeAttribute("key1"); // 해당 세션 삭제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>해당 세션 삭제</h1>
</body>
</html>
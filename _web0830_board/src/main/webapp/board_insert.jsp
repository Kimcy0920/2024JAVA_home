<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="boardJsonserver.jsp" method="post">
	<input type="hidden" name="action" value="create">
	제목: <input type="text" name="title" required><br>
	이름: <input type="text" name="writer" required><br>
	내용: <input type="text" name="content" required><br><br>
	<input type="submit" value="등록">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="empJsonserver1.jsp" method="post">
		<input type="hidden" name="action" value="create">
		<input type="text" name="ename" value="">ename<br>
		<input type="text" name="job" value="">job<br>
		<input type="text" name="mgr" value="">mgr<br>
		<input type="text" name="hiredate" value="">hiredate<br>
		<input type="text" name="sal" value="">sal<br>
		<input type="text" name="comm" value="">comm<br>
		<input type="text" name="deptno" value="">deptno<br>
		<input type="submit" value="INSERT">
	</form>
</body>
</html>
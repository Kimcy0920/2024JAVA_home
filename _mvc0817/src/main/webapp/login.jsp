<%@page import="mem.memDTO"%>
<%@page import="mem.memDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

memDAO dao = new memDAO();
memDTO dto = dao.memLogin(id, pw);

if (dto != null) {
	session.setAttribute("userId", dto.getId());
	session.setAttribute("password", dto.getPw());
    session.setAttribute("username", dto.getName());
    session.setAttribute("tel", dto.getTel());
    response.sendRedirect("main.jsp");   
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>

<%@page import="mem.memDTO"%>
<%@page import="mem.memDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String tel = request.getParameter("tel");

memDAO dao = new memDAO();
memDTO dto = dao.memCheck(id);
memDTO dto2 = new memDTO(id, pw, name, tel);

if (dto != null) {
%>
<script>
	alert('이미 등록된 아이디입니다.');
	history.back()
</script>
<%          
} else {
	dao.memSignup(dto2);
%>
<script>
	alert('가입이 완료되었습니다.');
	window.close();
</script>
<%
response.sendRedirect("login_form.jsp");
}
%>
</body>
</html>
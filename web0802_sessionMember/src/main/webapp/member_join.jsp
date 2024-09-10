<%@page import="member.memberDTO"%>
<%@page import="member.memberDAO"%>
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

memberDAO dao = new memberDAO();
memberDTO dto = dao.memberCheck(id);
memberDTO dto2 = new memberDTO(id, pw, name);

if (dto != null) {
%>
<script>
	alert('이미 등록된 아이디입니다.');
	history.back()
</script>
<%          
} else {
	dao.memberSignup(dto2);
%>
<script>
	alert('가입이 완료되었습니다.');
	window.close();
</script>
<%
}
%>
</body>
</html>
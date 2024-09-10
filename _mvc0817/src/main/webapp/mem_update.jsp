<%@page import="mem.memDTO"%>
<%@page import="mem.memDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String tel = request.getParameter("tel");
// System.out.println(pw);
// System.out.println(name);
// System.out.println(id);
memDAO dao = new memDAO();
memDTO dto = new memDTO(id, pw, name, tel);
dao.memUpdate(dto);
session.setAttribute("password", dto.getPw());
session.setAttribute("username", dto.getName());
session.setAttribute("usertel", dto.getTel());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('수정이 완료되었습니다.');
    opener.location.reload(true);  // 사용자 이름이 바뀌었으면 바로 반영
    window.close();
</script>

</body>
</html>
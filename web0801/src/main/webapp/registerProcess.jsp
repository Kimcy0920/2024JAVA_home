<%@page import="account.AccountDTO"%>
<%@page import="account.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");

AccountDAO dao = new AccountDAO();
AccountDTO dto = new AccountDTO(0, name, ssn, tel, 0);
dao.insertAccount(dto);
out.println("<script type='text/javascript'>");
out.println("alert('회원가입이 완료되었습니다.');");
out.println("window.location.href = 'index.jsp';");
out.println("</script>");
%>
</body>
</html>
<%@page import="member.memberDTO"%>
<%@page import="member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("userId");
String pw = (String)session.getAttribute("password");
String name = (String)session.getAttribute("userName");
// System.out.println(id);
// System.out.println(pw);
// System.out.println(name);
%>
        <form action="member_update.jsp" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" readonly
                               value="<%=id %>"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pw" 
                               value="<%=pw %>"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" 
                               value="<%=name %>"></td>
                </tr>
            </table>    
            <input type="submit" value="저장"> 
        </form>
    
</body>
</html>
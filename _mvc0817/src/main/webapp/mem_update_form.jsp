<%@page import="mem.memDTO"%>
<%@page import="mem.memDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            margin-bottom: 20px;
        }
        .login-container input {
            width: 95%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("userId");
String pw = (String)session.getAttribute("password");
String name = (String)session.getAttribute("username");
String tel = (String)session.getAttribute("tel");
%>
        <div class="login-container">
    	<h2>회원정보 수정</h2>
     		<form action="mem_update.jsp" method="post"> 
           		아이디: <input type="text" name="id" placeholder="id" value="<%=id %>" required><br>
          	 	비밀번호: <input type="password" name="pw" placeholder="password" value="<%=pw %>" required><br>
          	 	이름: <input type="text" name="name" placeholder="name" value="<%=name %>" required><br>
          	 	전화번호: <input type="text" name="tel" placeholder="tel" value="<%=tel %>" required><br>
            	<button type="submit">저장</button>
        	</form>
    	</div>
</body>
</html>
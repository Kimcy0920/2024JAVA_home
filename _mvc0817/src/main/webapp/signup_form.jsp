<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 95%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #333;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
	<div class="container">
        <h2>회원 가입</h2>
		<form action="signup.jsp" method="post">
			<label for="id">아이디:</label>
           	<input type="text" id="id" name="id" required>
            <label for="pw">비밀번호:</label>
            <input type="password" id="pw" name="pw" required>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
            <label for="tel">전화번호:</label>
            <input type="text" id="tel" name="tel" required>
            <input type="submit" value="등록">
        </form>
    </div>
</body>
</html>

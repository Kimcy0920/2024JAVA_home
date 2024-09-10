<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신짱구 팬페이지</title>
<link rel="icon"
	href="https://i.namu.wiki/i/kToKkRvHRvUs7w0CB6YaWZurCWPkxjBvk6pshWqF5uXomNoFMNT-2XATnkQaBFLnk4FMYfrlg5moFsdCInevJdGPzDRCTqpFBxNzDEbSI8h63O_CYXN5Ial9iqtk8cjYArUCV0J5OXRFMaRAyxhjG5DetkvDi_72G26E02thNFo.svg"
	type="image/x-icon">
<script src="https://kit.fontawesome.com/c47106c6a7.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css">
<script src="js/ie.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<div class="inner">
			<h1>
				<a href="main">짱구는 못말려</a>
			</h1>
			<ul id="gnb">
				<c:choose>
				<c:when test="${name ne null}">
            	<li><a href="list">게시판</a></li>
            	<li><a href="webhard">자료실</a></li>
				<li><a href="productList">장바구니</a></li>
				</c:when>
				<c:otherwise>
				<div1 title="로그인 후 이용이 가능합니다.">
				<li><a href="login_notice">게시판</a></li>
				<li><a href="login_notice">자료실</a></li>
				<li><a href="login_notice">장바구니</a></li>
				</div1>
				</c:otherwise>
				</c:choose>
				<li><a
					href="https://namu.wiki/w/%EC%A7%B1%EA%B5%AC%EB%8A%94%20%EB%AA%BB%EB%A7%90%EB%A0%A4/%EA%B7%B9%EC%9E%A5%ED%8C%90"
					target="_blank">극장판</a></li>
				<li><a
					href="https://namu.wiki/w/%ED%81%AC%EB%A0%88%EC%9A%A9%20%EC%8B%A0%EC%A7%B1/%EB%93%B1%EC%9E%A5%EC%9D%B8%EB%AC%BC"
					target="_blank">등장인물</a></li>
				<li><a
					href="https://github.com/Kimcy0920/202407JAVA/tree/master/_mvc0819_kcy"
					target="_blank">홈페이지 정보</a></li>
			</ul>
			<c:choose>
			<c:when test="${name ne null}">
			<ul class="util">
				<li><a>${name}님 환영합니다.</a></li>
                <li><a href="logout">로그아웃</a></li>
                <li><a href="mem_update_view">회원정보 수정</a></li>
            </ul> 
            </c:when>
        	<c:otherwise>
			<ul class="util">
                <li><a href="login_view">로그인</a></li>
                <li><a href="signup_view">회원가입</a></li>
            </ul>
			</c:otherwise>
			</c:choose>
		</div>
	</header>
	<figure1>
	<div class="inner">
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
		<div class="container" style="padding-top: 50;">
			<table class="table table-bordered table-hover">
				<tr>
					<th class="fname">파일명</th>
					<th class="ftime">업로드 시간</th>
					<th class="fsize">파일 크기</th>
					<th>삭제</th>
					<br>
				</tr>

				<c:forEach var="dto" items="${list}">
					<tr>
						<td class="left"><a href="files/${dto.fname}">
								${dto.fname} </a></td>
						<td>${dto.ftime}</td>
						<td class="right">${dto.fsize}&nbsp;&nbsp;</td>
						<td><a href="del_file?num=${dto.num}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<form action="add_file" enctype="multipart/form-data"
				method="post">
				<input type="file" class="form-control" name="upload"><br>
				<input type="submit" class="input-group-text" value="업로드">
			</form>
		</div>
	</div>
	</figure1>

	<footer>
		<div class="inner">
			<div class="upper">
				<h1>KimChangYong</h1>
				<ul>
					<li><a
						href="https://dept.du.ac.kr/computer/intro.do;jsessionid=0B24BFC3F24015BEF4E932322DA6E54A"
						target="_blank">동서울대학교 컴퓨터소프트웨어</a></li>
				</ul>
			</div>

			<div class="lower">
				<address>
					qkqhzmfjddl@naver.com & operztioncwal@gmail.com<br> TEL :
					010-8713-2971 C.P : 010-8713-2971
				</address>
				<p>2024 _mvc0819_kcy &copy; copyright all right reserved.</p>
			</div>
		</div>
	</footer>
</body>
</html>

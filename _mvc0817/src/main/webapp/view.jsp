<%@page import="board.BdDTO"%>
<%@page import="board.BdDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
BdDAO dao = new BdDAO();
BdDTO dto =  dao.getView(Integer.parseInt(num));
dao.hitsBoard(Integer.parseInt(num));
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신짱구 팬페이지</title>
    <link rel="icon" href="https://i.namu.wiki/i/kToKkRvHRvUs7w0CB6YaWZurCWPkxjBvk6pshWqF5uXomNoFMNT-2XATnkQaBFLnk4FMYfrlg5moFsdCInevJdGPzDRCTqpFBxNzDEbSI8h63O_CYXN5Ial9iqtk8cjYArUCV0J5OXRFMaRAyxhjG5DetkvDi_72G26E02thNFo.svg" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
    <style>
        table     { width:680px; text-align:center; border:ridge; background-color:gray;}
        th    { width:100px; background-color:gray; }
        td    { text-align:left; border:1px solid gray; background-color:white; }
    </style>
</head>
<body>
<header>
        <div class="inner">
            <h1><a href="main.jsp">짱구는 못말려</a></h1>

            <ul id="gnb">
            	<li><a href="list.jsp">게시판</a></li>
                <li><a href="https://namu.wiki/w/%EC%A7%B1%EA%B5%AC%EB%8A%94%20%EB%AA%BB%EB%A7%90%EB%A0%A4/%EA%B7%B9%EC%9E%A5%ED%8C%90" target="_blank">극장판</a></li>
                <li><a href="https://namu.wiki/w/%ED%81%AC%EB%A0%88%EC%9A%A9%20%EC%8B%A0%EC%A7%B1/%EB%93%B1%EC%9E%A5%EC%9D%B8%EB%AC%BC" target="_blank">등장인물</a></li>
                <li><a href="https://github.com/Kimcy0920/202407JAVA/tree/master/web0805_project" target="_blank">홈페이지 정보</a></li>
            </ul>
<%
	if ((String)session.getAttribute("userId") != null) {
%>
			<ul class="util">
				<li><a><%=(String)session.getAttribute("username")%>님 환영합니다.</a></li>
                <li><a href="logout.jsp">로그아웃</a></li>
                <li><a href="mem_update_form.jsp">회원정보 수정</a></li>
            </ul> 
<%  
    } else {
%>
			<ul class="util">
                <li><a href="login_form.jsp">로그인</a></li>
                <li><a href="signup_form.jsp">회원가입</a></li>
            </ul>
<%
    }
%>     
        </div>
</header>
<figure1>
	<img src="img/house1.jpg">
        <div class="inner"><br><br><br><br><br>
        <table>
    <tr>
        <th>제목</th>
        <td><%=dto.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=dto.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=dto.getRegtime() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=dto.getHits() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=dto.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='write2.jsp?num=<%=dto.getNum() %>'">
<input type="button" value="삭제"onclick="location.href='delete.jsp?num=<%=dto.getNum() %>'">
<br><br><br><br><br>
</div>
</figure1>
<section>
        <div class="inner">
            <h1>주요 인물 정보</h1>
            <div class="wrap">
                <article>
                    <div class="pic">
                        <img src="img/img1.jpg" alt="짱구 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EB%85%B8%ED%95%98%EB%9D%BC%20%EC%8B%A0%EB%85%B8%EC%8A%A4%EC%BC%80">신짱구</a></h2>
                    <p>크레용 신짱(짱구는 못말려)의 주인공. 노하라 히로시(신영식/신형만), 노하라 미사에(봉미선) 부부의 아들이며, 노하라 히마와리(신짱아)의 오빠이다.</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/img2.jpg" alt="짱아 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EB%85%B8%ED%95%98%EB%9D%BC%20%ED%9E%88%EB%A7%88%EC%99%80%EB%A6%AC">신짱아</a></h2>
                    <p>크레용 신짱의 등장인물. 노하라 히로시(신영식/신형만) & 노하라 미사에(봉미선) 부부의 사랑스런 딸이자, 노하라 신노스케(신짱구)의 하나 뿐인 여동생이다.</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/img3.jpg" alt="짱구아빠 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EB%85%B8%ED%95%98%EB%9D%BC%20%ED%9E%88%EB%A1%9C%EC%8B%9C">신형만</a></h2>
                    <p>크레용 신짱(짱구는 못말려)의 주요 인물. 노하라 미사에(봉미선)의 남편이자 노하라 신노스케(신짱구)와 노하라 히마와리(신짱아) 남매의 아버지다.</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/img4.jpg" alt="짱구엄마 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EB%85%B8%ED%95%98%EB%9D%BC%20%EB%AF%B8%EC%82%AC%EC%97%90">봉미선</a></h2>
                    <p>크레용 신짱(짱구는 못말려)의 주요 인물. 노하라 히로시(신영식/신형만)의 아내이자, 노하라 신노스케(신짱구)와 노하라 히마와리(신짱아) 남매의 어머니다.</p>
                </article>
            </div>
        </div>
    </section>

    <footer>
        <div class="inner">
            <div class="upper">
                <h1>KimChangYong</h1>
                <ul>
                    <li><a href="https://dept.du.ac.kr/computer/intro.do;jsessionid=0B24BFC3F24015BEF4E932322DA6E54A">동서울대학교 컴퓨터소프트웨어</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    qkqhzmfjddl@naver.com & operztioncwal@gmail.com<br>
                    TEL : 010-8713-2971 C.P : 010-8713-2971
                </address>
                <p>
                    2024 web0805_project &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>
</body>
</html>
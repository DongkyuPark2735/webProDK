<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body> 
	<header>
		<div class="gnb">
			<ul>
				<li><a href="">고객센터</a></li>
				<li><a href="">회원가입</a></li>
				<li><a href="<%=conPath%>/customer/loginForm.jsp">로그인</a></li>
			</ul>
		</div>

		<div class="logo">
			<h1>LOGO</h1>
		</div>
		<div class="lnb">
			<ul>
<!-- 				<li>로그인 전 메뉴 1</li> -->
<!-- 				<li>로그인 전 메뉴 2</li> -->
<!-- 				<li><a href="">로그인 전 메뉴 3</a></li> -->
<!-- 				<li><a href="">로그인 전 메뉴 4</a></li> -->
			</ul>
		</div>
	</header>
</body>
</html>






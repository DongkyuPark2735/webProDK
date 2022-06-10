<%@page import="com.lec.dto.CustomerDTO"%>
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
<%
	session.getAttribute("cid");
%>
<body> <!-- .gnb(로그인 전/후) -- .logo  -- .lnb(도서보기, 도서등록(로그인후)) -->
	<header>
		<div class="gnb">
			<%if(session.getAttribute("customer")==null){  %>
				<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->
			<ul>
				<li><a href="<%=conPath%>/fileboard/fboardlist.jsp">고객센터</a></li>
				<li><a href="<%=conPath%>/customer/joinForm.jsp">회원가입</a></li>
				<li><a href="<%=conPath%>/customer/loginForm.jsp">로그인</a></li>
			</ul>
			<%}else{ %>
				<!-- 로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보 수정, 고객이름 -->
			<ul>
				<li><a href="<%=conPath%>/fileboard/fboardlist.jsp">고객센터</a></li>
				<li><a href="<%=conPath%>/customer/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath%>/customer/modifyForm.jsp">정보수정</a></li>
				<li><a href="#"><%=((CustomerDTO)session.getAttribute("customer")).getCname()%></a></li>
			</ul>
			<%}%>
		</div>
		<div class="logo" onclick="location.href='<%=conPath %>/main/main.jsp'">
			<img src="https://cdn.dailyimpact.co.kr/news/photo/201907/53820_16097_1955.jpg"
				height="100px">
		</div>
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인후) -->
			<ul>
				<li><a href="<%=conPath %>/book/booklist.jsp">도서보기</a></li>
				<%if(session.getAttribute("customer")!=null){  %>
					<li><a href="<%=conPath %>/book/bookRegister.jsp">도서등록</a></li>
				<%} %>
			</ul>
		</div>
	</header>
</body>
</html>






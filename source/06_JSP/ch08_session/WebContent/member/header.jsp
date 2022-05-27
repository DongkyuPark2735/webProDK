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
	<style>
		header{
			width: 1000px;
			margin: 0 auto;
		}
		header #nav ul{
			overflow: hidden;
		}
		header #nav ul li{
			list-style: none;
			float: right;
			padding: 10px 30px;
		}
		header #nav ul li a{
			text-decoration: none;
			font-weight: bold;
			font-size: 1.5em;
			color : #7878E1;
		}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
				String id=null;
				String name = null;
				name = (String)session.getAttribute("name");
				id = (String)session.getAttribute("id");
 			%>
			<%if(name==null){//로그인 전 헤더 메뉴 %>
				<ul> <!-- href경로 수정할것  index에서 실행할떄 -->
					<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath%>/member/login.jsp">로그인</a></li>
					<li><a href="<%=conPath%>/member/main.jsp">홈</a></li>
				</ul>
			<%}else{ //로그인 후 헤더 메뉴%>
				<ul>
					<li><a href="<%=conPath%>/member/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath%>/member/modify.jsp">정보수정</a></li>
					<li><a href="#"><%=name%>(<%=id%>)님</a></li>
				</ul>
			<%} %>			
		</div>
	</header>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>ex02_scope.jsp페이지 입니다</h2>
  <h3>페이지내 속성변수 값 : ${pageName}</h3>
	<h3>request 속성변수 값 : ${requestName}</h3> <!-- 새롭게 request객체가 만들어져서 초기화 url주소가 새로 바뀌면 객체바뀜 foward하면 객체 그대로  -->
	<h3>session 속성변수 값 : ${sessionName}</h3>
	<h3>application 속성변수 값 : ${applicationName}</h3>
	<hr>
	<h3>이름 : ${param.name } <%= request.getParameter("name") %></h3><!--ㅍ파라미터는 객체이름 생략안됨 -->
	<h3>id : ${param.id } </h3>
</body>
</html>
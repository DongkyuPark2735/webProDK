<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
	<%!String name, id, password; %>
  <%
  	request.setCharacterEncoding("utf-8"); //post방식으로 파라미터 전송시   //post전달방식은 한글 꺠짐  인코딩 디코딩
  	name = request.getParameter("name");
  	id = request.getParameter("id");
  	password = request.getParameter("password");

  %>
  <h3>결과 화면</h3>
  <hr>
  <p>아이디는 <%=id %>이고</p>
  <p>패스워드는<%=password %>입니다</p>
	<p><%=name %>님 반갑습니다.</p>
</body>
</html>
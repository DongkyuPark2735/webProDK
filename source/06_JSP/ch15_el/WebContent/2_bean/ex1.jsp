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
  <form action="ex0.jsp" method="get">
  	<p>이름 : <input type="text" name="name"></p>
  	<p>ID : <input type="text" name="id"></p>
  	<p>비밀번호 : <input type="text" name="pw"></p>
  	<p><input type="submit"></p>
  </form>
</body>
</html>
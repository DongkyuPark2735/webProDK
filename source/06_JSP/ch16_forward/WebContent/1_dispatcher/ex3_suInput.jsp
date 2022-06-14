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
  <%int a = 5; %>
	<h2>a:<%=a %></h2>
	<h2>a:${a }</h2> <!-- 스크립트릿으로정의한거는 el표기법으로 출력못함 -->
	
<!-- 	<form action="ex3_suPro.jsp"> -->
	<form action="<%=conPath  %>/Ex3">
		누적을 원하는 수 <input type="number" min="1" name="su" required="required">
		<input type="submit" value="누적"> 	
	</form>
</body>
</html>
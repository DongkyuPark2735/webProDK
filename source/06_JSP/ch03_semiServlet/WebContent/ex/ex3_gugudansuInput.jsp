<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
<!-- 	<link href="../css/ex3.css" rel="stylesheet"> -->
<!-- <link href="http://localhost:8090/ch03_semiServlet/css/ex3.css" rel="stylesheet"> -->
	<link href="/ch03_semiServlet/css/ex3.css" rel="stylesheet">
					 <!-- context root루트로 생각함; -->
</head>

<!-- ex3.jsp 파라미터를 갖고 ex3서블릿에 요청 -->
<body>

<!-- 	<form action="../Ex3"> -->
	<form action="/ch03_semiServlet/Ex3" method="get">
		<select name="su">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7" selected="selected">7단</option>
			<option value="8">8단</option> <!-- value값이 없으면 해당 태그 안에 화면에 출력될 값이 넘어감 -->
			<option value="9">9단</option>
		</select>
		<input type="submit" value="구구단 출력">
	</form>
</body>
</html>
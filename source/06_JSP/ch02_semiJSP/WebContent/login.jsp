<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h3>로그인 화면</h3>
  <hr>
  <form action="result.jsp" method="post">
  	<table>
  		<tr>
  			<td>이름</td>
  			<td><input type="text" name="name"> </td>
  		</tr>
  		<tr>
  			<td>아이디</td>
  			<td><input type="text" name="id" > </td>
  		</tr>
  		<tr>
  			<td>패스워드</td>
  			<td><input type="password" name="password"  > </td>
  		</tr>
  	</table>
  	<input type="submit" value="로그인">
  </form>
</body>
</html>
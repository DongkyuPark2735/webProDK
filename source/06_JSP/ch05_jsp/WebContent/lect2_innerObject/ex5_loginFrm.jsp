<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	#msg{
  		color: red;
  		text-align: center;
  	}
  </style>
</head>
<body>
	<form action="ex5_loginCertification.jsp">
		아이디<input type="text" name="id" >
		패스워드<input type="password" name="pw">
		<input type="submit" value="로그인">
	</form>  
	<div id="msg">
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}
	%>
	</div>
</body>
</html>
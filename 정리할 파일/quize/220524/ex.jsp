<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>동전이 있는 곳을 맞춰봐</title>
  <style>
		div{
			width: 500px;
			margin: 0 auto;
			text-align: center;
			padding-top: 50px; 
			
		}  
  	form input {
			margin: 10px;
			text-align: center;
			width: 80px;
			height: 80px;
			background-color: #0064FF;
			border: 2px solid #0000FF ;
		}
		h3{
			text-align: center;
			color : red;
		}
  </style>
</head>
<body>
<div>
	<form action="exPro.jsp">
  	<input type="submit" name="coin" value="1번" >
  	<input type="submit" name="coin" value="2번" >
  	<input type="submit" name="coin" value="3번" >
	</form>
</div>
<%
	String msg= request.getParameter("msg");
	if(msg !=null){
		out.append(msg);
	}
%>
</body>
</html>
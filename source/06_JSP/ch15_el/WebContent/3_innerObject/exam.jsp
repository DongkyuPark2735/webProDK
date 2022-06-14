<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
  <style>
  	b{
  		color : red;
  	}
  </style>
</head>

<body>
	<form action="">
		<input type="number" name="num1" value="<%=(int)(Math.random()*9)+1%>">   
		* <input type="number" name="num2" value="<%=(int)(Math.random()*9)+1%>"> =  
		<input type="number" name="result" value="">
		  
		<input type="submit" value="확인" >  
		<br>
		<b>${param.num1} * ${param.num2} = ${param.result} 는
			 ${param.num1*param.num2 eq param.result }
			 ${not empty param.result? (param.result eq (param.num1*param.num2)?"true 정답":" false 오답") : ""} </b>
	</form>	
</body>
</html>
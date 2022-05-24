<%@page import="oracle.jrockit.jfr.tools.ConCatRepository"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	div{
  		width: 500px;
  		text-align: center;
  	}
  	h3:first-child {
			color : red;
		}
		div input{
			margin: 10px;
			text-align: center;
			width: 150px;
			height: 80px;
			background-color: #0064FF;
			border: 2px solid #0000FF;
		}
		h3{
			text-align: center;
		}
  </style>
</head>
<body>
	<%
		
		String tempCoin = request.getParameter("coin");
		String tempComCoin = null;
		String msg = "<h3>Wrong! Try Again!</h3><br><h3>("+tempCoin+"은(는) 아니고 정답은"+tempComCoin+")";
		int coin;
		int comCoin;
		
		if(tempCoin.equals("1번")){
			coin = 1;
		}else if(tempCoin.equals("2번")){
			coin = 2;
		}else{
			coin = 3;
		}
		comCoin = (int)(Math.random()*3)+1;
		if(comCoin == coin){
			out.append("<h3>정답입니다.</h3><br>");
			out.append("<h3>동전이 있던곳은 "+comCoin+"</h3><br>");
		}else{
  		tempComCoin = String.valueOf(comCoin);
  		msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("ex.jsp?msg="+msg);
		}
	%>
	<div>
	  <input type="button" onclick="history.go(-1);" value="뒤로가기">
	</div>
</body>
</html>
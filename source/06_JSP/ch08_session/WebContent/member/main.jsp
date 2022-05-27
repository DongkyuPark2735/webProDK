<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/Join.css" rel="stylesheet">
  <style>
  	#mainForm_wrap{
			width : 430px;
			margin : 0 auto;
			height : 410px;  		
			line-height: 410px;
			text-align: center;
			font-size: 1.5em;
			font-weight: blod; 
  		border : 2px solid #7878E1;
  		margin-top: 20px;
  		margin-bottom: 20px;
  	}
  	#mainContent{
  		color : #7878E1;
			font-weight: bold;
  	}  	
  </style>
</head>
<body>
  <jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		<h1 id="mainContent">main 화면</h1>
	</div>
  <jsp:include page="footer.jsp"/>
</body>
</html>
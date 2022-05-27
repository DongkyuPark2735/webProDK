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
  	#logoutMsg{
  		color : #7878E1;
			font-weight: bold;
			box-sizing: border-box;
  	}
  </style>
  <script>
  	setTimeout(function() {
	  	location.href='main.jsp';
  	}, 5000)
  </script>
</head>
<body>
  <%
  	String name = null; 
  	name = (String)session.getAttribute("name");
  	session.invalidate();
  %>
	<jsp:include page="header.jsp"/>  <!-- 헤더 파일이 로그인 전에  세션 제거(로그아웃) 헤더파일을 로그인 전으로  -->
  <div id="mainForm_wrap">
		<h3 id="logoutMsg">
			<%=name%>님 로그아웃 되었습니다.<br>
			 5초후 자동으로 페이지가 이동됩니다.
		</h3>
	</div>
  <jsp:include page="footer.jsp"/>
</body>
</html>




























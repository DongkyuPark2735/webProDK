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
 <jsp:useBean id="member" class="ch15_el.Member"/>
  	<jsp:setProperty property="*" name="member"/>
  	<h2>bean태그를 이용한 정보 출력</h2>
  	<h3>이름 : <jsp:getProperty property="name" name="member"/></h3>
  	<h3>id : <jsp:getProperty property="id" name="member"/></h3>
  	<h3>pw : <jsp:getProperty property="pw" name="member"/></h3> 
  	
	 <h2>표현식을 이용한 정보 출력</h2>
  	<h3>이름 : <%=member.getName() %></h3>
  	<h3>id : <%=member.getId() %></h3>
  	<h3>pw : <%=member.getPw() %></h3>

  	<h2>el 을 이용한 정보 출력</h2>
  	<h3>이름 : ${member.name }</h3><!-- getter를 찾음-->
  	<h3>id : ${member.id }</h3>
  	<h3>pw : ${member.pw }</h3>
  	
</body>
</html>
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
  <!-- requst객체가 새로만들어지지않는다. jsp : forward 주소창이 바뀌지않음 -->

	<form action="ex02_scope.jsp">
		<p>이름<input type="text" name="name"> </p>
		<p>ID<input type="text" name="id"> </p>
		<p><input type="submit"> </p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");
		session.setAttribute("sessionName", "sessionValue");
		application.setAttribute("applicationName", "applicationValue");
		
		// forward(dispatcher) forward는 객체정보 안고 감 
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa"); // forward함
		dispatcher.forward(request, response);
		
		//response.sendRedirect(location) 안됨
		
		
	%>
	<%-- <jsp:forward page="ex02_scope.jsp"/> --%>
	<h3>page 속성변수 값 : <%= pageContext.getAttribute("pageName") %></h3>
	<h3>request 속성변수 값 : <%= request.getAttribute("requestName") %></h3>
	<h3>session 속성변수 값 : <%= session.getAttribute("sessionName") %></h3>
	<h3>application 속성변수 값 : <%= application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지내 속성변수 값 : ${pageScope.pageName}</h3>
	<h3>request 속성변수 값 : ${requestScope.requestName}</h3>
	<h3>session 속성변수 값 : ${sessionScope.sessionName}</h3>
	<h3>application 속성변수 값 : ${applicationScope.applicationName}</h3>
	<hr>
	<h3>페이지내 속성변수 값 : ${pageName}</h3>
	<h3>request 속성변수 값 : ${requestName}</h3><!-- scope생략가능  attribute 이름 같으면 안됨  -->
	<h3>session 속성변수 값 : ${sessionName}</h3>
	<h3>application 속성변수 값 : ${applicationName}</h3>
	
</body>
</html>






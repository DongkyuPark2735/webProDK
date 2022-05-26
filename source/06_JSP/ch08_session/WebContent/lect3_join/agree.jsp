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
  <%
  	request.setCharacterEncoding("utf-8");
  	String id =	request.getParameter("id");
  	String pw =	request.getParameter("pw");
  	String name =	request.getParameter("name");
  	session.setAttribute("id", id);
  	session.setAttribute("pw", pw);
  	session.setAttribute("name", name);
  %>
	<h2><%=name %>님 약관에 동의하십니까?</h2>
	<hr>
	<ol>
		<li><h3>회원정보는 웹사이트 운영을 위해서만 사용</h3></li>
		<li><h3>웹사이트의 정상적인 운영을 방해하는 회원은 탈퇴처리합니다.</h3></li>
	</ol>
	<hr>
	<fieldset>
		<legend>약관 동의</legend>
		<form action="joinOk.jsp">
			동의<input type="radio" name="agree" value="y" checked="checked" class="btn">
			거부<input type="radio" name="agree" value="n" class="btn">
			<input type="submit" value="확인" class="btn">
		</form>
	</fieldset>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/서버프로그램평가/css/style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<%
		String cid = (String)session.getAttribute("cid");
		if(session.getAttribute("customer") != null){ //로그인 상태
		response.sendRedirect("main.jsp");
	}
	%>
	<form action="loginOk.jsp" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>로그인</th>
				<td><input type="text" name="cid" required="required"
					value="<%=(cid != null) ? cid : ""%>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="cpw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"> 
					<input type="button" value="회원가입" onclick="location.href='join.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<%
						String msg = request.getParameter("msg");
						if(msg != null) {
					%>
 					<p>아이디와 비밀번호를 잊으셧나요?</p> 
				<%} %>
					<p>아직 회원이 아니신가요?<a href="join.jsp">회원가입</a></p>
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>
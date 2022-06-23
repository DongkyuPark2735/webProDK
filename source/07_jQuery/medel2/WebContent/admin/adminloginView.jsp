<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style></style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			
		});
	</script>
</head>
<body>
<jsp:include page="/main/header.jsp"/>
	<form action="${conPath}/adminlogin.do" method="post">
	<table>
		<caption>관리자 모드 로그인</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="aid" required="required"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="apw" required="required"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
	</form>
<jsp:include page="/main/footer.jsp"/>	
</body>
</html>
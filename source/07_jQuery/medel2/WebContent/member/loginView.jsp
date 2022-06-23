<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style></style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
			$('form').submit(function () {
			});
	});
</script>
</head>
<link href="${conPath }/css/style.css" rel="stylesheet">
<body>
<jsp:include page="/main/header.jsp"/>
	<form action="${conPath}/login.do" method="post">
	<table>
		<caption>사용자님 로그인</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" required="required"
								 value="${mid }"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw" required="required"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location.href='${conPath}/joinView.do'">
			</td>
		</tr>
	</table>
	</form>
<jsp:include page="/main/footer.jsp"/>	
</body>
</html>
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
	<jsp:include page="../main/header.jsp"/>
		<div>글쓰기</div>
		<div id="content_form">
			<table>
				<tr>
					<th>글번호</th>				
					<th>작성자</th>				
					<th>글제목</th>				
					<th>조회수</th>				
					<th>날짜</th>				
					<th>IP</th>				
				</tr>
			</table>			
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
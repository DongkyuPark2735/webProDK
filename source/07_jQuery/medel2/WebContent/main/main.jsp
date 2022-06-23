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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	#content_form {
		width: 800px; height:500px; line-height:500px;
		margin: 0 auto; text-align: center; font-size: 3em;
	}
</style>
<c:if test="${not empty loginResultMSG}">
	<script>
		alert('${loginResultMSG }');
		history.back();
		//location.href = '${conPath}/loginView.do?error=error';
	</script>
</c:if>

<c:if test="${not empty adminLoginResultMSG}">
	<script>
			alert('${adminLoginResultMSG }');
			history.back();
	</script>
</c:if>

<c:if test="${not empty joinResult}">
	<script>
			alert('${joinResult }');
	</script>
</c:if>

<c:if test="${not empty joinErrorMsg}">
	<script>
			alert('${joinErrorMsg }');
			history.back();
	</script>
</c:if>


</head>
<body>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
			main
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>studentOk.jsp 페이지입니다.</h2>
	<h3>confirm된 ID : ${id }(model의 id O)</h3>
	<h3>confirm된 ID : ${param.id }(파라미터의 id O)</h3>
</body>
</html>
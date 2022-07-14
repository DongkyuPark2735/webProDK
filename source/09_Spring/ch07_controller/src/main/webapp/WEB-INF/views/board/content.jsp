<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>board의 content.jsp페이지 입니다.</h2>
	<table>
		<tr>
			<th>ID : </th>
			<td>${id }</td>
		</tr>
		<tr>
			<th>PW : </th>
			<td>${pw }</td>
		</tr>
		<tr>
			<th colspan="2">${member } (toString()결과)</th>
		</tr>
		<tr>
			<th>member.getId() :</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>member.getPw() :</th>
			<td>${member.pw }</td>
		</tr>
	</table>
	<h2 onclick="history.back()">이전페이지로 가기</h2>
</body>
</html>
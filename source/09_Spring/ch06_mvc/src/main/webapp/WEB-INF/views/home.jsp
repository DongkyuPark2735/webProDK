<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="/css/style.css" rel="stylesheet">
<!-- link에 conpath빼도 됨 -->
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  ${greeting } </P>
<P>  2022년 07월 14일 </P>
<p><img alt="text" src="img/wedding-img1.jpg" width="900" height="500"></p>
</body>
</html>

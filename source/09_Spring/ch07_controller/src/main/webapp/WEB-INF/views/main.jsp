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
	<h1>${greeting }</h1>
	<hr>
	<h1>Board관련 요청 경로</h1>
	<h3><a href="${conPath }/board/write">Board에 write로 가기</a></h3>
	<h3><a href="${conPath }/board/content">Board에 content로 가기</a></h3>
	<h3><a href="${conPath }/board/list">Board에 list로 가기</a></h3>
	<h3><a href="${conPath }/board/reply">Board에 reply로 가기</a></h3>
	<hr>
	<h1>Member관련 요청 경로</h1>
	<p><button onclick="location.href='${conPath }/member?method=join'">회원가입</button></p>
	<p><button onclick="location.href='${conPath }/member?method=login'">로그인</button></p>
	<p><button onclick="location.href='${conPath }/member?method=logout'">로그아웃</button></p>
	<p><button onclick="location.href='${conPath }/member?method=infoModify'">정보수정</button></p>
	<hr>
	
</body>
</html>
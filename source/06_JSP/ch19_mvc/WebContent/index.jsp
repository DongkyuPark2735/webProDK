<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/bstyle.css" rel="stylesheet">
</head>
<body>
  <h1><a href="${conPath }/memberList.do">회원리스트</a></h1>
  <h1><a href="${conPath }/memberJoin_view.do">회원가입</a></h1>
  <!-- memberJoin.do  // 회원가입폼 form태그안에 -->

</body>
</html>
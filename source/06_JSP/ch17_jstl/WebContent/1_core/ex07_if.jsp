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
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
  <%
  if(1+2==3){
	  out.println("1+2는 3입니다.");
  }else{
	  out.println("1+2는 3이 아니다");
  }
  %>
  <c:if test="${1+2 eq 3}">
  	1+2는 3입니다<br>
  </c:if>
  <c:if test="${1+3 != 3}" var="result" scope="page">
  	1+2는 3이 아니다<br>
  </c:if>
  두번째 if문 조건에 대한 결과는 ${result }입니다
</body>
</html>


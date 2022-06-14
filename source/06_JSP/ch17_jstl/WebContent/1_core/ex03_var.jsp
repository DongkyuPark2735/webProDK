<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>변수 선언과 출력</h2>
	<c:set var="varName" value="varValue"/>
	 varName : ${varName }<br>
	<c:set var="varName" value="abc <varValue>"/> 
	 varName : ${varName }<br>
	 
	 <!--  escapeXml="true" : 특수문자 인식-->
	 varName : <c:out value="${varName }" escapeXml="ture"/><br> <!--  -->
	
	<c:remove var="varName"/><!-- 변수삭제 -->
	 varName : ${varName }<br>
	 varName : ${empty varName ? "삭제되서 없음" : "남아있음" }<br>
	 
	 <c:set var="varName" value="null"/> <!-- 없는 변수 강제로 못넣음 -->
	 varName : <c:out value="${varName }" default="없어진 변수"/>
	  
</body>
</html>














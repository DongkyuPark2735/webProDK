<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%@page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
 	<h2>공사중 입니다. 500 에러 빠른 시일내로 복구하겠습니다.</h2>
 	<h4>관리자 문의 : hong@hong.com</h4> 
<%
	System.out.println(exception.getMessage());
	System.out.println(exception.getClass().getName());
%>
	
</body>
</html>
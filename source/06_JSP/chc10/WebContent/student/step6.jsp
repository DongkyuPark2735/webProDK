<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
		<jsp:setProperty name="st" property="*"/>
		<jsp:forward page="stResult.jsp"/>  	
</body>
</html>
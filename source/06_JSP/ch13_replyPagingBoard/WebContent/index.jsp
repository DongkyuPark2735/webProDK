<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
	<%-- <jsp:forward page="board/list.jsp"/>  --%> <!-- index주소값넘어감 --> 
	<% response.sendRedirect("board/list.jsp"); %> <!-- 주소값  -->
 	
</body>
</html>
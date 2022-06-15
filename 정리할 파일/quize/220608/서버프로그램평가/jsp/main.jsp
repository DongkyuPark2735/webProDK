<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.CustomerDTO"%>
<%@page import="com.lec.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/서버프로그램평가/css/style.css" rel="stylesheet">
</head>
  <jsp:include page="header.jsp"/>
<body>

<div>
	<h2>메인화면</h2>
</div>
</body>
  <jsp:include page="footer.jsp"/>
</html>
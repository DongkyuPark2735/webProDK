<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
	<%// 스크립트립?
	Date now = new Date();
	String str = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분", now);
	Calendar now2 = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 mm월 dd일");
	String str2 = sdf.format(now2.getTime());
	%>
	<%=str %><br>
	<%=str2 %>
</body>
</html>
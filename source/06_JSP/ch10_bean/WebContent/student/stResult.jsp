<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
  <jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/> 
  <h2>입력된 학생</h2>
  <p>학번 <jsp:getProperty name="st" property="sno"/></p>
  <p>이름 <jsp:getProperty name="st" property="name"/></p>
  <p>학년 <jsp:getProperty name="st" property="grade"/></p>
  <p>반 <jsp:getProperty name="st" property="sclass"/></p>
  <p>점수 <jsp:getProperty name="st" property="score"/></p>
  
</body>
</html>
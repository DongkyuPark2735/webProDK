<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String conPath = request.getContextPath();// 	ch06_standardActionTag %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex5_include.jsp 페이지입니다.</h1>
	<h2>반갑습니다.</h2>
	<%-- <%@ include file="includePage.jsp" %>  --%><!-- comPath가 중복위험이 있다  해당 include가 있어서 오류 --> <!--jsp 파일 원본 그대로  다들어옴 include-->
	<jsp:include page="includePage.jsp"/> <!-- jsp파일의 결과를  include 페이지 수행한 html이 옴  -->  
	<h1>다시 ex5_include.jsp 페이지 입니다.</h1>
</body>
</html>
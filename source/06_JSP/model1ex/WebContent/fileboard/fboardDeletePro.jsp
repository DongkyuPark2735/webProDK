<%@page import="com.lec.dto.FileboardDTO"%>
<%@page import="com.lec.dao.FileboardDAO"%>
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
  <%
  	String pageNum = request.getParameter("pageNum");
  	int fnum = Integer.parseInt(request.getParameter("fnum"));
  	String fpw = request.getParameter("fpw");
  	
  	FileboardDAO fdao = FileboardDAO.getInstance();
		
  	int result = fdao.deleteBoard(fnum, fpw);
  
  	if(result == FileboardDAO.SUCCESS){
  %>
  	<script>
  		alert('<%=fnum%>번글 삭제성공');
  		location.href='fboardList.jsp?pageNum=<%=pageNum%>';
  	</script>
  <%}else{%>
  	<script>
  		alert('<%=fnum%>번글 삭제실패 비밀번호를 확인하세요');
  		history.go(-1);
  	</script>
  		
  <%}
  %>
</body>
</html>
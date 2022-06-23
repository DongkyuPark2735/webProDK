<%@page import="com.lec.fileboardDTO.FileBoardDTO"%>
<%@page import="com.lec.fileboardDAO.FileBoardDAO"%>
<%@page import="com.lec.memberDAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style></style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			
		});
	</script>
</head>
<body>

<%
	FileBoardDAO fdao = FileBoardDAO.getInstance();
	FileBoardDTO fdto = new FileBoardDTO();
	for(int i=1; i<100; i++){
		fdto.setMid("aaa");
		fdto.setFtitle("제목"+i);
		fdto.setFcontent("본문"+i);
		fdto.setFstep(0);
		fdto.setFindent(0);
		fdto.setFip("123.123.123.1");
		fdao.writeFileBoard(fdto);	
	}
%>        
</body>
</html>








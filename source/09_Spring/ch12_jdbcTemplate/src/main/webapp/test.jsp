<%@page import="com.lec.ch12.vo.BoardDTO"%>
<%@page import="com.lec.ch12.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%
		BoardDao bdao = BoardDao.getInstance();
		BoardDTO bdto = new BoardDTO();
		
		for(int i = 1; i < 101; i ++){
			bdto.setBname("홍길동" + i);
			bdto.setBtitle("제목" + i);
			bdto.setBcontent("본문입니다." + i);
			bdto.setBip("127.12.10."+ i);
			int result =	bdao.write(bdto);
			System.out.println(i+"번째 :" + (result==1?"성공":"실패"));
		}
		response.sendRedirect("mvcboard/list.do");
	
	
	%>
</body>
</html>

















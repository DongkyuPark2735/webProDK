<%@page import="com.lec.dao.BoardDAO"%>
<%@page import="com.sun.xml.internal.ws.client.sei.ResponseBuilder.Body"%>
<%@page import="com.lec.dto.BoardDTO"%>
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
		String pw = request.getParameter("pw");
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.deleteBorad(num, pw);
		if(result == BoardDAO.SUCCESS){
	%>
		<script>
			alert('<%=num%>번 글 삭제 성공');
			location.href = 'list.jsp?pageNum=<%=pageNum%>';
		</script>	
	<%}else{%>
		<script>
			alert('<%=num%>번 글 삭제 실패 , 비밀번호를 확인하세요');
			history.back();
		</script>	
	<%}%>  
</body>
</html>
<%@page import="com.lec.dao.BoardDAO"%>
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
  request.setCharacterEncoding("utf-8");
  String pageNum = request.getParameter("pageNum");
  
  %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDTO" scope="page"/>
		<jsp:setProperty name="dto" property="*"/>
	<%
		dto.setIp(request.getRemoteAddr());//요청한곳 ip
		BoardDAO dao = BoardDAO.getInstance();
		int result;
		if(dto.getNum()==0){
		  result = dao.insertBoard(dto); //원글쓰기
		}else{
			result = dao.reply(dto);// 답변글쓰기
		}
	
		if(result == BoardDAO.SUCCESS){
	%>
		<script>
			alert('글쓰기 완료');
			location.href = 'list.jsp?pageNum=<%=pageNum%>';
		</script>
	<%}else{%>
		<script>
			alert('글쓰기 실패');
			history.back();
		</script>
	<%}
	%>

</body>
</html>
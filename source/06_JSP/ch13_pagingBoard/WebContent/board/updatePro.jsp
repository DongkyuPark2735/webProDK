<%@page import="com.lec.dao.BoardDAO"%>
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
	<%request.setCharacterEncoding("utf-8");  %>
		<jsp:useBean id="dto" class="com.lec.dto.BoardDTO"/>
			<jsp:setProperty name="dto" property="*"/>
		<!-- 들어온 파라미터 : subjectm content, email, pw, num --%>
		<!-- dao의 updateBoard를 호출하기 위해서는 : subject, content, email. pw, num, ip -->
	<%
		String pageNum = request.getParameter("pageNum");
		dto.setIp(request.getRemoteAddr());
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.updateBoard(dto);		
		if(result == BoardDAO.SUCCESS){%>
			<script>
				alert('글 수정 성공');
				location.href = 'list.jsp?pageNum=<%=pageNum%>';
				<%-- location.href = 'content.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>';  --%>/* 상세보기페이지로 */
			</script>
		<%}else{ %>
			<script>
				alert('글 수정 실패');
				history.go(-1);
			</script>
		<%}
		
	%>  
</body>
</html>
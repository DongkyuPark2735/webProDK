<%@page import="com.lec.dto.CustomerDTO"%>
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
  <style>
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDAO fdao = FileboardDAO.getInstance();
		fdao.hitUp(fnum);
		FileboardDTO fdto = fdao.getBoard(fnum);
	%>
		<table>
			<caption>글 상세보기</caption>
			<tr>
				<th>글번호</th>
				<td><%= fdto.getFnum() %></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><%= fdto.getFsubject() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%= fdto.getCname() %>
						(<a href="mailto:<%= fdto.getCemail()!=null ? fdto.getCemail():"" %>">
						<%= fdto.getCemail()!=null?fdto.getCemail():"-" %></a>)</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				<%
					if(fdto.getFfilename()==null){
						out.println("첨부파일 없음");
					}else{
						out.println("<a href='../fileboardUpload/"+fdto.getFfilename()+"'>"
												+fdto.getFfilename()+"</a>");
					}
				%>
				</td>
			</tr>
			<tr>
				<th>본문</th><!-- 특수문자등 모든 내용 나오기위해 -->
				<td><pre><%= fdto.getFcontent() %></pre></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><pre><%= fdto.getFrdate()%></pre></td>
			</tr>
			<tr>
				<th>조회수</th><!-- 특수문자등 모든 내용 나오기위해 -->
				<td><pre><%= fdto.getFhit() %></pre></td>
			</tr>
			<tr>
				<th>IP</th><!-- 특수문자등 모든 내용 나오기위해 -->
				<td><pre><%= fdto.getFip() %></pre></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="목록" onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
					<%
					String cid = null;
					CustomerDTO cdto = (CustomerDTO)session.getAttribute("customer");
					if(cdto != null){
						cid= cdto.getCid();
					}
					if(fdto.getCid().equals(cid)){ //
					%>
						<input type="button" value="수정" onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
					<%}
					if(cdto!=null){
					%>
						<input type="button" value="답변" onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
					<%} %>
					<input type="button" value="삭제" onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</div>
 	<jsp:include page="../main/footer.jsp" />
</body>
</html>







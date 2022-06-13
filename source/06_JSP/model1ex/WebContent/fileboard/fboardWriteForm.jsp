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
			height: 550px; 
			padding-top:50px;
		}
	</style>
</head>
<!-- 답변글 쓰기랑 원글쓰기 구분해야함 fnum이랑 pageNum 으로 구분  -->

<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<%
			if(session.getAttribute("customer")==null){
				response.sendRedirect(conPath+"/customer/loginForm.jsp");
			}
			String pageNum = request.getParameter("pageNum");
			if(pageNum ==null) pageNum ="1";
			int fnum = 0; //글번호는  0으로  초기화
			FileboardDTO fdto = new FileboardDTO(); //빈 dto객체 (fnum, fref, fre_step, fre_level은 0)
			if(request.getParameter("fnum")!=null){//답글쓰러옴
				fnum = Integer.parseInt(request.getParameter("fnum"));
				FileboardDAO fdao = FileboardDAO.getInstance();
				fdto = fdao.getBoard(fnum);// 원글에 대한 정보 (fref, fre_step, fre_level이 필요)
			}
		%>
	<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%= pageNum %>">
		<input type="hidden" name="fnum" value="<%= fnum %>">
		<input type="hidden" name="fref" value="<%= fdto.getFref() %>">
		<input type="hidden" name="fre_step" value="<%= fdto.getFre_step() %>">
		<input type="hidden" name="fre_level" value="<%= fdto.getFre_level()%>">
		<table>
			<caption><%= fnum==0? "글쓰기" : "답변글쓰기" %></caption>		
			<tr>
				<th>제목</th>
				<td><input type="text" name="fsubject" required="required" autofocus="autofocus" 
									 value="<%if(fdto.getFsubject()!=null){
									 						out.print("답]"+fdto.getFsubject());
									 					}%>"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="ffilename"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="20" name="fcontent"></textarea></td>
			</tr>
			<tr>
				<th>삭제비밀번호</th>
				<td><input type="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value='<%= fnum==0? "글쓰기" : "답쓰기"%>' class="btn">
					<input type="reset" value='다시쓰기' class="btn">
					<input type="button" value='목록' class="btn" onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>	
	</form>
	</div>
 	<jsp:include page="../main/footer.jsp" />
</body>
</html>



































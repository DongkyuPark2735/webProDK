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
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDAO fdao = FileboardDAO.getInstance();
		FileboardDTO fdto = fdao.getBoard(fnum);
		System.out.println(fdto);
	%>
		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%= pageNum %>">
			<input type="hidden" name="dbfilename" 
						 value="<%=fdto.getFfilename()==null?"-":fdto.getFfilename() %>">
		<table>
			<caption>글 수정</caption>
			<tr>
				<th>글번호</th>
				<td><input type="text" name="fnum" value="<%= fdto.getFnum() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="fsubject" value="<%= fdto.getFsubject() %>" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="ffilename1" style="width:30%;">
					<%
						if(fdto.getFfilename()!=null){
							out.println("첨부파일 없음 : "+fdto.getFfilename());
						}else{
							out.println("첨부파일 없음");
						}
					%>				
				</td>
			</tr>
			<tr>
				<th>본문</th><!-- 특수문자등 모든 내용 나오기위해 -->
				<td><textarea rows="5" cols="20" name="fcontent"><%= fdto.getFcontent() %></textarea></td>
			</tr>
			<tr>
				<th>삭제용비밀번호</th><!-- 특수문자등 모든 내용 나오기위해 -->
				<td><input type="password" name="fpw" value="<%=fdto.getFpw() %>" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
	 		  	<input type="reset" value="이전"  class="btn" onclick="history.go(-1)">
					<input type="button" value="목록" class="btn" onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		 </table>
		</form>
	</div>
 	<jsp:include page="../main/footer.jsp" />
</body>
</html>
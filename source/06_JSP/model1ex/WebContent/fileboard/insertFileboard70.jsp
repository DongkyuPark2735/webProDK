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
</head>
<body>
<%
	FileboardDAO dao = FileboardDAO.getInstance();
	FileboardDTO dto = new FileboardDTO();
	for(int i =0; i<70; i++){
		if(i%3==0){
			dto.setCid("ddd");			
		}else if(i%3==1){
			dto.setCid("eee");			
		}else if(i%3==2){
			dto.setCid("fff");			
		}
		dto.setFsubject("for문으로 강제 입력한글"+i);
		dto.setFcontent("본문내용");
		if(i%5==0){
			dto.setFfilename("쿠키.docx");
		}else{
			dto.setFfilename(null);
		}
		dto.setFpw("111");
		dto.setFip("192.168.10."+i);
		dao.insertBoard(dto);
	}
	response.sendRedirect("fboardList.jsp");

%>  
</body>
</html>
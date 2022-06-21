<%@page import="com.lec.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%//idConfirm.jsp?mid=aaa
	String mid = request.getParameter("mid");
	MemberDAO mdao = MemberDAO.getInstance();
	
	int result = mdao.loginCheck(mid);
	
	if(result == MemberDAO.FAIL){
		out.println("중복된 ID입니다.");
	}else{
		out.println("사용가능한 ID입니다.");
	}
%>
</body>
</html>
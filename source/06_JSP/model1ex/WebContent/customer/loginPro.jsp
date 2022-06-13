<%@page import="com.lec.dto.CustomerDTO"%>
<%@page import="com.lec.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
 	String cid =	request.getParameter("cid");
 	String cpw =	request.getParameter("cpw");
 	CustomerDAO cdao = CustomerDAO.getInstance();
 	
 	int result = cdao.loginCheck(cid, cpw);
 	if(result == CustomerDAO.LOGIN_SUCCESS){
		CustomerDTO cdto =	cdao.getCustomer(cid); 	
 		session.setAttribute("customer", cdto);
		//session.setAttribute("cid", cid);
 		out.println("<script>alert('로그인 성공');");
 		out.println("location.href='../main/main.jsp';</script>");
 	}else{
 		out.println("<script>alert('로그인 실패 아이디와 비밀번호를 확인하세요 ');");
 		out.println("history.back();</script>");
 	}

%>
</body>
</html>
<%@page import="com.lec.dto.CustomerDTO"%>
<%@page import="com.lec.dao.BoardDAO"%>
<%@page import="com.lec.dto.BoardDTO"%>
<%@page import="com.lec.dao.CustomerDAO"%>
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
  	String cid = request.getParameter("cid");
  	String cpw = request.getParameter("cpw");
  	String cname = request.getParameter("cname");
  	
  	CustomerDAO dao = CustomerDAO.getInstance();
  	int result = dao.checkLoginCustomer(cid, cpw);
  	
  	if(result == CustomerDAO.SUCCESS){
				CustomerDTO infodto = dao.getCustomerInfo(cid);
				session.setAttribute("infodto", infodto);
				session.setAttribute("cid", cid);
				session.setAttribute("cname", cname);
				out.println("<script>alert('로그인 성공');"+
										"location.href='main.jsp </script>");
  	}else{
  		out.println("<script>alert('로그인 실패 : 아이디와 비밀번호를 확인하세요');"+
									"history.back(); </script>");
  	}
  %>
</body>
</html>




















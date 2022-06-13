<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDAO"%>
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
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDTO" scope="page" />
		<jsp:setProperty property="*" name="dto"/>
  <%
	  String tempbirth = request.getParameter("tempbirth");
		dto.setCbirth(Date.valueOf(tempbirth));
		
  	CustomerDAO dao = CustomerDAO.getInstance();
  	
		int idchek = dao.confirmCid(dto.getCid());
		if(idchek == CustomerDAO.CUSTOMER_NONEXISTENT){
	  	int result = dao.insertCustomer(dto);
	  	if(result == CustomerDAO.SUCCESS){
				out.println("<script>alert('회원가입 감사합니다.로그인 이후에 서비스를 이용하세요');"+
														"location.href='loginForm.jsp'; </script>");
		  	session.setAttribute("cid", dto.getCid());
	  	}else{
				out.println("<script>alert('회원가입이 실패되었습니다. 너무 긴 데이터는 가입이 불가합니다.');"+
														"history.back(); </script>");
	  	}
	  	
		}else if(idchek == CustomerDAO.FAIl){
			out.println("<script>alert('회원가입이 실패되었습니다. 중복된 id입니다.');"+
													"history.back(); </script>");
		}
  %>
</body>
</html>








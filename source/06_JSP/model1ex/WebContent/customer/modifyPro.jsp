<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDAO"%>
<%@page import="com.lec.dto.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
CustomerDTO dto = (CustomerDTO) session.getAttribute("customer");
%>
<jsp:useBean id="dtos" class="com.lec.dto.CustomerDTO" scope="page" />
<jsp:setProperty property="*" name="dtos" />
<%
	String tempbirth = request.getParameter("tempbirth");
if (tempbirth != null) {
	dtos.setCbirth(Date.valueOf(tempbirth));
}

CustomerDAO dao = CustomerDAO.getInstance();

String newCpw = dtos.getCpw();
String sessoinCpw = dto.getCpw();
String oldpw = request.getParameter("oldpw");

if (sessoinCpw.equals(oldpw)) {
	int result = CustomerDAO.FAIl;
		System.out.println(newCpw);

	if (newCpw == null) {
		System.out.println(newCpw);
		dtos.setCpw(oldpw);
	}

	result = dao.updateCustomer(dtos);

	if (result == CustomerDAO.SUCCESS) {
		session.setAttribute("customer", dtos);
		out.println("<script>alert('회원수정 성공');" + "location.href='loginForm.jsp'; </script>");
	} else {
		out.println("<script>alert('회원수정 실패');" + "history.back(); </script>");
	}
} else {
	out.println("<script>alert('비밀번호가 맞지 않습니다.');" + "history.back();  </script>");
}
%>

<body>

</body>
</html>










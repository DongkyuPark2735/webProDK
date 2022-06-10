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
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDTO" />
	<jsp:setProperty name="dto" property="*" />
	<%
	String tempbirth = request.getParameter("tempbirth");
	dto.setCbirth(Date.valueOf(tempbirth));
	
	dto.setCbirth(Date.valueOf(request.getParameter("tempbirth")));
	
	CustomerDTO tempdto = (CustomerDTO)session.getAttribute("infodto");
	String sessionPw = null;
	
	CustomerDTO tempdto = (CustomerDTO) session.getAttribute("infodto");
	String sessionPw = null;

	if (tempdto != null) {
		sessionPw = tempdto.getCpw();
	}
	
	String oldPw = request.getParameter("oldPw");
	if (sessionPw.equals(oldPw)) {
		if (dto.getCpw() == null) {
			dto.setCpw(sessionPw);
		}
		CustomerDAO dao = CustomerDAO.getInstance();
		int result = dao.modifyCustomer(dto);// 수정
		
		System.out.println(result);
		if (result == CustomerDAO.SUCCESS) {
			session.setAttribute("infodto", dto);
	%>
	<script>
		alert('정보 수정완료 됨었음. 확인하세요');
		location.href = 'main.jsp';
	</script>
	<%
		} else {
	%>
	<script>
		alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다.');
		location.href = 'modify.jsp';
	</script>
	<%
		}
	} else {
	%>
	<script>
		alert('기존 비밀번호가 바르지 않습니다. 확인하세요');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>




















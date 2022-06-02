<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
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
	 %> 
  
  	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
  	<jsp:setProperty name="dto" property="*" /><!-- name에 해당하는 객가 없으면 해당 name명으로 객체생성  -->
  	<!--date형  name같으면 오류?-->
  <%
		String tempbirth = request.getParameter("tempbirth");
  	if(!tempbirth.equals("")){
  		dto.setBirth(Timestamp.valueOf(tempbirth+" 00:00:00"));
  		//dto.setBirth(Date.valueOf(tempbirth));
  	}
		MemberDaoConn mDao = new MemberDaoConn();	// 싱글톤 아님 // 왜싱글톤이안되지?? 
		int result = mDao.confirmID(dto.getId()); // 중복체크
		if(result == MemberDaoConn.MEMBER_NONEXISTENT){// 사용가능한 ID
			result = mDao.joinMember(dto);//회원가입
			if(result == MemberDaoConn.SUCCESS){// 회원가입 성공
				session.setAttribute("id", dto.getId());%>
				
				<script>
					alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요');
					location.href='login.jsp';
				</script>
				
		<%}else{ // 회원가입 실패%>
				
				<script>
					alert('회원가입 실패입니다. 다시가입해주세요');
					location.href='join.jsp';
				</script>
							
		<%}
			
		}else{ //중복된 ID	%>

		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>
			
	<%}%>	
</body>
</html>


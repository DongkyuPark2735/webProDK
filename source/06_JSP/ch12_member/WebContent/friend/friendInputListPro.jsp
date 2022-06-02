<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="fdto" class="com.lec.friend.FriendDto" scope="page"/>
		<jsp:setProperty name="fdto" property="*"/>
	<%
		
		FriendDao fdao = FriendDao.getInstance();
		String fname = request.getParameter("fname");
		String ftel = request.getParameter("ftel");
		int result = fdao.friendsUpdate(fname, ftel);
//		if(fname.length()<2){
//			out.println("<script>	alert('이름은 2글자 이상입력해야합니다.');	</script>");
//			response.sendRedirect("friendInputList.jsp");
//		}

		//int result = fdao.friendsUpdate(fname, ftel);
				
		//session.setAttribute("fname", fname);
		
		if(result == FriendDao.SUCCESS){
		%>
			<script>	
				alert('이름 <%=fname %> 전화번호 <%=ftel %> 친구가 추가되었습니다');
				location.href="friendInputList.jsp";
			</script>
		<%
		}else if(result == FriendDao.FAIL){
		%>
			<script>	
				alert('해당 친구의 입력 실패하였습니다.');	
			</script>
		<%response.sendRedirect("friendInputList.jsp");
		}
	  %>  
</body>
</html>
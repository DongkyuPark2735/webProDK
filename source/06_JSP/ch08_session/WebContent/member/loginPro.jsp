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
  	boolean ok = false;
  	String msg = "";
  	request.setCharacterEncoding("utf-8");
  	
  	String tempId = request.getParameter("id");
  	String tempPw = request.getParameter("pw");
   	
  	if(tempId ==null || !tempId.equals("aaa") || tempPw == null || !tempPw.equals("111")){
  		response.sendRedirect("login.jsp?msg=xx");
  	}else{
  		//로그인 처리
	  	session.setAttribute("name", "홍길동");
	  	session.setAttribute("id",  "aaa");
			session.setAttribute("pw",  "111");
  		%>
 <!--  
  
	  if(pw!=null && pw.equals("111")){// pw가 맞는 경우
		  // 로그인 처리 = 세션속성(id, name) 추가한 후 welcome.jsp로 가기
		  session.setAttribute("id",id);
		  /* session.setAttribute("pw",pw); */
		  session.setAttribute("name","홍길동");
		  response.sendRedirect("welcome.jsp");
	  }else{
		  msg = URLEncoder.encode("pw를 체크하세요", "utf-8");
		  response.sendRedirect("login.jsp?msg="+msg);
	  }
	  
  }else{ // 유효하지 않은 id를 입력한 경우
	  msg = URLEncoder.encode("id를 체크하세요", "utf-8");
	  response.sendRedirect("login.jsp?msg="+msg);
  } -->
		<script>
  		alert("로그인 성공");
      location.href='main.jsp';
  	</script>
  	<%
  	}
  %>
  
</body>
</html>
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
  	String id = request.getParameter("id");
  	String pw = request.getParameter("pw");
  	
  	/* if(id !=null && id.equals("aaa")){
  			if(pw != null && pw.equals("111")){
  		ok = true; // 올바른 id와 올바른 pw를 입력한 경우 
  		}else{
  			msg = "check the PW!;";
  		}
  	}else{
  		msg = "check the ID!";
  	} 
  	if(!ok){
  		response.sendRedirect("login.jsp?msg="+msg);
  	}*/
  	
  	if(id ==null || !id.equals("aaa") || pw == null || !pw.equals("111")){
  		response.sendRedirect("login.jsp?msg=xx");
  	}else{
  		//로그인 처리
  		Cookie cookie = new Cookie("id", id);
  		cookie.setMaxAge(-1);
  		response.addCookie(cookie);
  		%>
		<script>
  		alert("로그인 성공");
      location.href='main.jsp';
  	</script>
  	<%
  	}
  %>
  
</body>
</html>
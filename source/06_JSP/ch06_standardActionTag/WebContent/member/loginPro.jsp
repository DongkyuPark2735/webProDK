<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
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
  	}
  %>
  <br><br><br><br><br>
  <div id="loginForm_wrap">
  	<div id="login_title">로그인 결과</div>
  	<p id="login_join">로그인 성공</p>
  </div>
  <br><br><br><br><br>
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
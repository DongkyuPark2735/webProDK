<%@page import="java.net.URLEncoder"%>
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
  String msg = "";
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  
  if(id!=null && id.equals("aaa")){ //id.equals("aaa") 이퀄문 500 에러발생 
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
  }
  %>
</body>
</html>
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
<%!
String id, pw; //선언부 변수는 자동 초기화 
%>  
<%
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	// 입력받은 id, pw가 DB에 있는지 확인 절차
	if(id != null&&id.equals("aaa")&&pw!=null&&pw.equals("111") ){
		Cookie cookie = new Cookie("id",id);
		cookie.setMaxAge(-1); //유효시간은 브라우저 닫을 때까지
		response.addCookie(cookie); 
		
		Cookie cookie2 = new Cookie("name","홍길동"); //db에서 가져온 이름을 쿠키값으로
		cookie2.setMaxAge(-1); 
		response.addCookie(cookie2); 
		response.sendRedirect("welcome.jsp");
	}else{
		
	%>
	<script>
		alert("id와 비밀번호를 확인하세요");
		location.href='login.html';
	</script>
<%		
	/* response.sendRedirect("login.html"); 
		어차피 화면전환될것이라 인식하기 때문에 먼저시행된다.
			시행중인 버퍼를 멈추고 시행, 알람이 뜰수도 있고 안뜰수도 있음  
			태그상에 있는건 시행 안됨

		스크립트나 html등 해당 페이지에서 뭔가 동작하고 넘어갈때는 location			
			*/
	}
%>
</body>
</html>














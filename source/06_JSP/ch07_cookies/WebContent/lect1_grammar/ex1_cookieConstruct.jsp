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
	Cookie cookie = new Cookie("cookieName", "cookieValue"); //첫번쨰 매개변수로 쿠키 이름 , 두번째 매개변수로 해당쿠키의 값
	cookie.setMaxAge(60*60); // 1시간 유효한 쿠키  클라이언트 단위로 가지고있음?// 매개변수 값으로 -1은 로그아웃 할때까지
	response.addCookie(cookie); // response 객체에 탑재해 줘야함  화면에 나타나진않고 특정파일에 쿠키 들어감  
%>  
	<h2>지금 막 생성된 쿠키 이름 : <%=cookie.getName()%></h2>
	<h2>지금 막 생성된 쿠키의 값 : <%=cookie.getValue()%></h2>
	<hr>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름 -쿠키값)리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a><br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>
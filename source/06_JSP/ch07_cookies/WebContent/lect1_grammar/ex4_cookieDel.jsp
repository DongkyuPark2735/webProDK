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
<h1>특정 쿠키 (쿠키이름이 cookieName인 쿠키)삭제하기</h1> <!--모든 쿠키 삭제 하려면 for문 // 특정쿠키 만 삭제할수있음-->
  <%
  	Cookie[] cookies = request.getCookies();
  	if(cookies!=null){
  		for(Cookie c : cookies){
  			String name = c.getName();
  			if(name.equals("cookieName")){
  				// 쿠키 삭제 : 유효기간이 0초짜리 같은 이름의 쿠키를 만들어 덮어씀
					Cookie cDel = new Cookie("cookieName","xxx"); // 쿠키는 덮어쓸수있음
  				cDel.setMaxAge(0); //삭제하는 함수가 없음 // 사용자에게 있어서
  				response.addCookie(cDel);
  				out.println("<h3>쿠키 삭제 성공</h3>");
  				break;
  			}
  		}
  	}
  %>
  
<hr>  
  <a href="ex1_cookieConstruct.jsp">쿠키 생성(cookieName)</a><br>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름 -쿠키값)리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a><br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>
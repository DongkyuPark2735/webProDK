<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css"> 
</head>
<body>
 <%
 String id=null, name=null;
 Cookie[] cs = request.getCookies();
 
 if(cs!=null){
	 for(int i = 0; i<cs.length; i++){
			if(cs[i].getName().equals("id")){
				id = cs[i].getValue();
			}else if(cs[i].getName().equals("name")){
				name = cs[i].getValue();
			}
	 }// for- 로그인 후 : id변수에 로그인한 id가 name변수에는 로그인한 name이 할당
    //			로그인 전 : id변수와 name변수엔 null값
 }
 %>
 <%if(name!=null){%> //로그인 후
 			<h1><%=name %>(<%=id %>)님 반갑습니다.</h1>
 			<button onclick="location.href='logout.jsp'">로그아웃</button>
 			<button onclick="location.href='cookielist.jsp'" >쿠키들 확인</button>
 <%}else{//로그인 전 화면 %>
 			<h1>로그인하세요</h1>
 			<button onclick="location.href='login.html'">로그인</button>
 			<button onclick="location.href='cookielist.jsp'">쿠키들 확인</button>
 <%} %>		
</body>
</html>
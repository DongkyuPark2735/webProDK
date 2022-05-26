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
  	Cookie[] c = request.getCookies();
		if(c!=null){
			for(Cookie co : c){
				if(co.getName().equals("id")){
					co.setMaxAge(0);
					response.addCookie(co);
					break;
				}
			}
		}
		/* response.sendRedirect("main.jsp"); */
  %>
  <script>
  	alert("로그아웃 되었습니다.");
  	location.href='main.jsp';
  </script>
</body>
</html>




























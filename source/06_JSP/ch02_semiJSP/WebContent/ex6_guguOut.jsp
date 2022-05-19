<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	td{
  	padding: 5px;
  	}
  </style>
</head>
<body>
  <%
  // 자바의Integer.parseInt에 빈스트링 매개변수로 넣으면 에러
  // 자바스크립트에서는 0
  int su1 = Integer.parseInt(request.getParameter("su1"));
  int su2 = Integer.parseInt(request.getParameter("su2"));
  
  %>
  <h3></h3>
  <table>
  <%for(int i = 1; i<=9; i++){%>
	<tr>
	 <%for(int j = su1; j<=su2; j++){%>
  		<td><%=j %> * <%=i %> = <%= i * j  %></td>
	  <% }%>
	</tr>
  <% }%>
  </table>
  <br><br>
  <button onclick="history.back();">뒤로가기</button>
  <button onclick="location.href='ex6_su2Input.html';">새로하기</button>
</body>
</html>
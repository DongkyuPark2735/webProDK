<%@page import="com.lec.book.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
 	<table>
		<tr>
 <%
 	BookDAO bdao = BookDAO.getInsetance();
 	ArrayList<BookDTO> books = bdao.listBook();
 	for(int i = 0; i<books.size(); i++){
 %>		<td>
 				<img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
 				<%= books.get(i).getBtitle()%><br>
 				<del><%=books.get(i).getBprice()  %></del>(<%=books.get(i).getBdiscount() %>할인)<br>
 				<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
 			<td>
		<%if(i%3==2)out.println("</tr><tr>"); %> 	
 	
 	
 <%}
 System.out.println(5%3);
 %> 
		</tr>
 	</table>
</body>
</html>
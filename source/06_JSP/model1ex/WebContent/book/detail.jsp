<%@page import="com.lec.dto.BookDTO"%>
<%@page import="com.lec.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/bstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
  <%
  	int bid = Integer.parseInt(request.getParameter("bid"));
  	String pageNum = request.getParameter("pageNum");
  	BookDAO bdao = BookDAO.getInsetance();
  	BookDTO book = bdao.getBook(bid);
  %>
		<table>
			<tr>
				<td rowspan="4"><img src="<%=conPath%>/bookImg/<%=book.getBimage1()%>"></td>	
				<th><%=book.getBid() %>번 도서 상세보기</th>
			</tr>		
			<tr>
				<td><%= book.getBtitle() %></td>
			</tr>
			<tr>
				<td>
				<%if(book.getBdiscount()!=0){ %>
				<del><%= book.getBprice() %></del><br>
				<%= book.getBprice() *(100-book.getBdiscount())/100 %><br>
				<b><%= book.getBdiscount()%> %할인</b>
				<%}else{ %>
					<b><%=book.getBprice() %></b>
				<%} %>
				</td>
			</tr>
			<tr>
				<td>
					<button>구매</button>
					<button onclick="location='booklist.jsp?pageNum=<%=pageNum %>'">목록</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<img src="<%=conPath %>/bookImg/<%= book.getBimage2() %>"><br>
					<pre><%= book.getBcontent() %></pre>
				</td>
			</tr>		
		</table>
			<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<%@page import="com.lec.dto.BookDTO"%>
<%@page import="com.lec.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
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
 	<table>
		<tr>
 <%// paging 추가 : PAGESIZE = 3. BLOCKSIZE = 4
 	
 	BookDAO bdao = BookDAO.getInsetance();
 	final int PAGESIZE = 3, BLOCKSIZE = 4;
 	String pageNum = request.getParameter("pageNum"); 
 	if(pageNum == null) pageNum = "1";
 	int currentPage = Integer.parseInt(pageNum);
 	
 	int totalPageCnt = (int)Math.ceil((double)bdao.getBookTotCnt()/PAGESIZE);
 	int startRow = (currentPage -1)*PAGESIZE +1;
 	int endRow = startRow + PAGESIZE-1;
 
	ArrayList<BookDTO> books = bdao.listBook(startRow, endRow);
 	
 	for(int i = 0; i<books.size(); i++){
 %>
 		<td>
 			<a href="detail.jsp?bid=<%=books.get(i).getBid() %>&pageNum=<%=pageNum%>">
 				<img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
 				
 				<%= books.get(i).getBtitle()%><br>
 				<%System.out.println(books.get(i));%>
 			</a>
 				<del><%=books.get(i).getBprice()  %></del>(<%=books.get(i).getBdiscount() %>할인)<br>
 				<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
 			<td>
 	
 <%}%> 
		</tr>
 	</table>
 		<div class="paging">
		<%
			int bookTotalCnt = bdao.getBookTotCnt();
			int pageCnt =(int)Math.ceil((double)bookTotalCnt / PAGESIZE);
			int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
			int endPage = startPage + BLOCKSIZE-1;
			if(endPage>pageCnt)endPage=pageCnt;
			
			if(startPage> BLOCKSIZE){
		%>
			[<a href="booklist.jsp?pageNum=<%=startPage-1 %>">이전</a>]		
		<%	
			}
			for(int i = startPage; i<=endPage; i++){
				if(i==currentPage){
					out.println("[<b>"+i+"</b>]");
				}else{
					out.println("[<a href='booklist.jsp?pageNum="+i+"'>"+i+"</a>]");
				}
			}
			if(endPage<pageCnt){
		%>
	     [<a href="booklist.jsp?pageNum=<%=endPage+1 %>">다음</a>]
		<%}%>
		</div>
			
			<jsp:include page="../main/footer.jsp"/>
</body>
</html>








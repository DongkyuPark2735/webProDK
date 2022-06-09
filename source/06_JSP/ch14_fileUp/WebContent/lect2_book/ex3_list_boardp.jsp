<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDTO"%>
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
	<%// ex3_list_boardp.jsp 또는 ex3_list_boardp.jsp?pageNum=1 또는 ex3_list_boardp.jsp?pageNum=5
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLCOKSIZE=4;
		int startRow = (currentPage-1) * PAGESIZE+1;
		int endRow = startRow + PAGESIZE - 1;
		
		BookDAO bdao = BookDAO.getInsetance();
		ArrayList<BookDTO> books = bdao.listBook(startRow, endRow); 
	%>  
	<table>
		<caption>책리스트</caption>
			<tr>
				<th>책ID</th><th>책이름</th><th>책대표이미지</th><th>가격</th><th>할인율</th>
			</tr>
			<%if(books.size()==0){
					out.println("<tr><td colspan='5'>등록된 책이 없습니다.</td></tr>");
				}else{
					for(BookDTO book : books){
						out.println("<tr><td>"+book.getBid()+"</td><td>"+book.getBtitle()+"</td>");
						out.println("<td><img src='../bookImg/"+book.getBimage1()+"' width='15'></td>");
						out.println("<td>"+book.getBprice()+"</td><td>"+book.getBdiscount()+"</td></tr>");
					}
				}
			%>
			
	</table>
	<div class="paging">
		<%
			int bookTotalCnt = bdao.getBookTotCnt();
			int pageCnt =(int)Math.ceil((double)bookTotalCnt / PAGESIZE);
			int startPage = ((currentPage-1)/BLCOKSIZE)*BLCOKSIZE+1;
			int endPage = startPage + BLCOKSIZE-1;
			if(endPage>pageCnt)endPage=pageCnt;
			
			if(startPage> BLCOKSIZE){
		%>
			[<a href="ex3_list_boardp.jsp?pageNum=<%=startPage-1 %>">이전</a>]		
		<%	
			}
			for(int i = startPage; i<=endPage; i++){
				if(i==currentPage){
					out.println("[<b>"+i+"</b>]");
				}else{
					out.println("[<a href='ex3_list_boardp.jsp?pageNum="+i+"'>"+i+"</a>]");
				}
			}
			if(endPage<pageCnt){
		%>
	     [<a href="ex3_list_boardp.jsp?pageNum=<%=endPage+1 %>">다음</a>]
		<%}%>
	</div>				
</body>
</html>


















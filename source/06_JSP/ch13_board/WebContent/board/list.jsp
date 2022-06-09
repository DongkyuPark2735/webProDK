<%@page import="com.lec.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDAO"%>
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
  	<caption>게시판</caption>
  	<tr>
  		<td><a href="<%=conPath%>/board/writeForm.jsp">글쓰기</a></td>
  	</tr>
  </table>
  <table>
  	<tr>
  		<th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th>
			<%
				final int PAGINSIZE = 10, BLOCKSIZE = 10;
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) pageNum = "1";
				int currentPage = Integer.parseInt(pageNum);
				
				int startNum =  (currentPage -1) * PAGINSIZE +1;
				int endNum = startNum + PAGINSIZE - 1;
				
				
				BoardDAO dao = BoardDAO.getInstance();
				int totalCnt = dao.getBoardTotalCnt();	
				if(totalCnt ==0){
					out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
				}else{
					ArrayList<BoardDTO> dtos = dao.listBoard(startNum, endNum);
					for(BoardDTO dto : dtos){
						//글번호, 작성자, 글제목, 메일, 조회수
						out.println("<tr><td>"+dto.getNum()+"</td><td>"+dto.getWriter()+"</td>");
						//글제목<td class='left'><img src='/ch13_board/img/hot.gif'>
						//<a href='/ch13_board/board/content.jsp'>글제목</a></td>
						out.println("<td class='left'>");
						if(dto.getReadcount() >10){
								out.println("<img src='"+conPath+"/img/hot.gif'>");
						}
						out.println("<a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+
													"'>"+dto.getSubject()+"</a></td>");
						//메일, 조회수
						out.println("<td>"+(dto.getEmail()!=null ? dto.getEmail():"")+"</td><td>"+dto.getReadcount()+
												"</td></tr>");
					}
				}
			%>  
			<%
			int pageCnt = (int)Math.ceil((double)totalCnt/PAGINSIZE);		
			int startPage = (currentPage-1/BLOCKSIZE)*BLOCKSIZE+1;
			int endPage = startPage + BLOCKSIZE -1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE){ 
				out.println("[<a href='list.jsp?pageNum=" + (startPage - 1) + "'>이전</a>]");
			}
			for(int i = startPage; i<endPage; i++){
			  if(i == currentPage){
					out.println("[<b>" + i + "</b>]");
			  }else{
					out.println("[<a href='list.jsp?pageNum=" + i + "'>" + i + "</a>]");
			  }
			}
			if(endPage < pageCnt){
				out.println("[<a href='list.jsp?pageNum=" + (endPage + 1) + "'>다음</a>]");
			}
			%>			
  	</tr>
  </table>
</body>
</html>













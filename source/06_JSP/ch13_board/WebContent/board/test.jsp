<%@page import="com.lec.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<a href="xx.jsp">xx</a>
<%-- 	<%
		BoardDAO dao = BoardDAO.getInstance();

	int result = dao.getBoardTotalCnt();

	out.println("<h3>1. DB글갯수 : " + result + "</h3>");
	out.println("<h3>2. 글목록</h3>");
	ArrayList<BoardDTO> dtos = dao.listBoard();
	for (BoardDTO dto : dtos) {
		out.println("<h3>" + dto + "</h3>");
	}

	out.println("<h3>3. 글 쓰기</h3>");
	BoardDTO dto = new BoardDTO(0, "김길동", "글제목 \n", "본문\n입니다.", null, 0, "1", 0, 0, 0, "127.0.0.2", null);
	int rs = dao.insertBoard(dto);
	out.println(rs == BoardDAO.SUCCESS? "글쓰기 성공": "글쓰기 실패");
	
	out.println("<h2>4와5. 조회수 올리고 글 번호로 dto가져오기 </h2>");
	
	dao.readCountUp(3);
	dto = dao.getBoardOneLine(3);
	out.println(dto);
	
	out.println("수정전의 2번글"+dto);
	out.println("");
	out.println("<h2>6. 글 수정</h2>");
	out.println("");
	dto.setSubject("ㅌㅌㅌㅌㅌ바뀐제목 xxxx");
	dto.setContent("ㅌㅌㅌㅌㅌ바뀐 본문 yyyy");
	result = dao.updateBoard(dto);
	if(result == BoardDAO.SUCCESS){
		dto = dao.getBoardOneLine(3);
		out.println("");
		out.println("수정후의 2번글"+dto);
	}else{
		out.println("수정실패");
	}
	
	
	dto = dao.getBoardOneLine(3);
	out.println("<h2>7.글 삭제</h2>");
	result = dao.deleteBorad(3, "12");
	out.println(result==BoardDAO.SUCCESS? "2번글 삭제 성공":"2번 글 삭제 실패");
	result = dao.deleteBorad(3, "1");
	out.println(result==BoardDAO.SUCCESS? "2번글 삭제 성공":"2번 굴 삭제 실패");
	%> --%>
</body>
</html>









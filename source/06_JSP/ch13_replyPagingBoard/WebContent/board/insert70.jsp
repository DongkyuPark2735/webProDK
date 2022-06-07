<%@page import="com.lec.dto.BoardDTO"%>
<%@page import="com.lec.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%
  	//임의로 70개 글 insert(원글)하기 
  	BoardDAO dao = BoardDAO.getInstance();
  	BoardDTO dto = new BoardDTO();
		for(int i = 0; i <70; i++){
			
			dto.setWriter("홍길동" + i);
			dto.setSubject("제목"+i+"입니다");
			dto.setContent("본문입니다." + i);
			dto.setEmail("hong"+i+"@hong.com");
			dto.setPw("1");
			dto.setIp("192.168.10."+i);
			
			int result = dao.insertBoard(dto);
			System.out.println(result == BoardDAO.SUCCESS ? i+"번 성공" : i+"번 실패");
			
		}
  	response.sendRedirect("list.jsp");
  	%>
</body>
</html>
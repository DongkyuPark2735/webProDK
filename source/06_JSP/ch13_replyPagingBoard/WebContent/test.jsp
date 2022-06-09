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
	final int PAGESIZE = 10, BLOCKSIZE = 10;

	String pageNum = request.getParameter("pageNum");
	
	int currentPage = Integer.parseInt(pageNum);
	
	int startRow = (currentPage - 1) * PAGESIZE + 1;

	if (pageNum == null)
		pageNum = "1"; // 전달받은 pageNum파라미터가 없으면 1페이지로
		
	
	int endRow = startRow + PAGESIZE - 1;
%>
</body>
</html>
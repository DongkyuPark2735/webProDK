<%@page import="java.util.Iterator"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.lec.dto.BookDTO"%>
<%@page import="com.lec.dao.BookDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
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
<link href="<%=conPath%>/css/bstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<%
		// 한글 인코딩처리 -  MultipartRequest객체 생성 - 첨부된 파일명get - 그외 파라미터 input에서 입력된 정보 get - insert 
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("bookImg");
	
	int maxSize = 1024 * 1024 * 5; //바이트 단위임  
	String[] image = { "", "" }; // 저장된 파일들의 이름 
	MultipartRequest mRequest = null;
	
	try {
		//MultipartRequest객체 생성 파일이름 받으려고                                             //파일이름 한글일수도있어서                                //같은이름 파일일떄 자동 이름 지정 
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());

		// 서버에 저장된 파일명 get
		//enumeration 으로 파라미터 이름 받는다
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들, 뒷파일부터 넘어옴 
		
		int idx = 0;
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement(); // 파라미터이름
			image[idx] = mRequest.getFilesystemName(param); // 첨부한 파일명이아니라 저장된 파일명
			idx++;
		}

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	//서버(톰켓)의 bookImg 폴더 파일 소스의 bookImg폴더로 복사
	for (String img : image) {
		if (img != null) {
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path + "/" + img);
			try {
		is = new FileInputStream(serverFile);
		os = new FileOutputStream("C:/workspaces/eclipse-worspace/model1ex/WebContent/bookImg/" + img);
		
		byte[] bs = new byte[(int) serverFile.length()]; 
		
		while (true) {
			int readbyteCnt = is.read(bs);
			if (readbyteCnt == -1)
				break;
			os.write(bs, 0, readbyteCnt);
		}
			} catch (Exception e) {
		System.out.println(e.getMessage());
			} finally { //jsp 자바에서는 실행안되서 예외  		 //was에서 에러 구문해서 를  브라우져로 던진다 
		if (os != null)
			os.close();
		if (is != null)
			is.close();
			}
		}
	}

	//파일첨부외 파라미터에서 입력된 정보 get
	int bid = 0;
	String btitle = mRequest.getParameter("btitle");
	int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	String bimage1 = image[1] == null ? "noImg.png" : image[1];
	String bimage2 = image[0] != null ? image[0] : "NOTHING.JPG";
	String bcontent = mRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
	Date brdate = null;

	//DB에 insert
	BookDAO bDao = BookDAO.getInsetance();
	BookDTO book = new BookDTO(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
	int result = bDao.insertBook(book);
	if (result == BookDAO.SUCCESS) {
		out.println("<h2>책 등록 성공</h2>");
	} else {
		out.println("<h2>책 등록 실패</h2>");
	}
	%>

	<h3>책이름 : <%=btitle %></h3>
	<h3>책대표이미지 : <%=path %>/<%=bimage1 %></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage1 %>" alt="대표">
	<h3>책이미지2 : <%=path + "/" + bimage2 %></h3>
	<img src="../bookImg/<%=bimage2%>">
	<h3>책 설명</h3>
	<pre><%=bcontent %></pre>
	<h3>책가격 : <del><%=bprice %></del> <%=bprice*(100-bdiscount)/100 %>원</h3>
	<h3>할인율 : <%=bdiscount %></h3>
	<a href="booklist.jsp">책  리스트(paging 추가된 쇼핑몰 스타일)</a>
		<jsp:include page="../main/footer.jsp"/>
</body>
</html>





















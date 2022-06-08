<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
  <%
  /* MultipartRequest객체가 request객체 대체*/
		String path = request.getRealPath("fileUpFolder");
  	//out.println(path);
  	int maxSize = 1024*1024*10; // 업로드 최대 용량 10mb
  	String filename = ""; // 서버에 저장될 파일 이름 
  	String originalFilename = ""; //파일 이름 중복시 이름 바뀌어서 저장됨
  	
  	try{
	  																											 /*request의 모든 권한을 넘김  */						/*같은이름의 파일이 있을경우 rename: 1.jpg -> 11.jpg  */
			MultipartRequest multipartrequest = new MultipartRequest(request, path, maxSize,"utf-8",new DefaultFileRenamePolicy());																																					
	  											/*MultipartRequest 예외처리 해줘야함  */						 /*절대경로가 들어갈수없음? 무조건 톰켓폴더에 거처가야함   */
  		Enumeration<String> paramNames = multipartrequest.getFileNames(); //파일 타입의 파라미터이름들
  		String param = paramNames.nextElement(); // 파라미터 이름 'file'
  		filename = multipartrequest.getFilesystemName(param); // 파라미터 이름으로 저장된 파일 이름 
			originalFilename = multipartrequest.getOriginalFileName(param); // 오리지널 파일 이름 
			// 파일 첨부를 하지 않을 경우 filename과 originalfilename에는 null;
			System.out.println("파라미터 이름 : "+param+"/서버에 저장된 파일이름 : " +filename +
																		"/사용자가 업로드한 오리지널 파일이름 : "+ originalFilename);
  	}catch(IOException e){
  		System.out.println(e.getMessage());
  	}
  	//서버 fileUpFolder 폴더에 업로드한 파일을  소스의 fileUpFolder폴더로 file copy
  	InputStream is = null;
		OutputStream os = null;
		try{
			File serverfile = new File(path+"/"+filename);
			if(serverfile.exists()){// 첨부한 파일이 있는지. 첨부하지 않았으면 파일 복사 안함
				is = new FileInputStream(serverfile); // 원본파일 
				os = new FileOutputStream("D:/webProDK/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+filename);//복사될 파일
				byte[] bs = new byte[(int)serverfile.length()];
				while(true){
					int nReadCnt = is.read(bs);//파일의 끝이 아닐경우 읽어들인 byte수 : nReadCnt
					if(nReadCnt == -1) break;
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("완료");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(os!=null)os.close();
			if(is!=null)is.close();
		}
		
		if(filename!=null){//첨부함
	%>
		<h3>첨부한 오리지널 파일 이름 : <%=originalFilename %></h3>	
		<h3>서버에 저장된 파일 이름 :<%=path %> / <%=filename%></h3>
		<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="첨부파일"	>
	<%
		}else{ // 첨부안함 
			out.println("<h2>첨부 안함 </h2>");
		}
  %>
</body>
</html>

























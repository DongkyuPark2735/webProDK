<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	String conPath = request.getContextPath();
	String appPath = application.getContextPath(); //  /ch05_jsp 상대경로
	String absolutePath = application.getRealPath(".");// '.'은 현재 프로젝트의 절대경로 
	//D:\webProDK\IDE\apache-tomcat-9.0.63\wtpwebapps\ch05_jsp  실행되는 경로 
	//실행되는 경로 에 있는 파일은 리프레쉬할때(껏다킬떄) 정리됨? 
%>	  
	<h2>comPath h : <%=conPath %></h2>
	<h2>appPath h : <%=appPath %></h2>
	<h2>absolutePath h : <%=absolutePath %></h2>
<%
	String filePath = application.getRealPath("WEB-INF/input.txt");
	out.println(filePath + "의 내용입니다. <br><br>");
	// 스트림 객체 생성(파일 연다) - 읽는다 - 스트림객체를 닫는다.(파일 닫는다)
	
	BufferedReader br = new BufferedReader(new FileReader(filePath)); 
	while(true){
		String line = br.readLine(); 
		if(line == null){
			break;
		}
		out.println(line + "<br>");
	}
	br.close(); //JSP에서는 위처럼 해도 된다. was가 알아서 오류 처리 해줌 	// 500에러 어디서?
							//서블렛에서는 아래처럼 	
	/* BufferedReader br = null;
	try{
		br = new BufferedReader(new FileReader(filePath));//보조객체이기에 매개변수로 
		while(true){
			String line = br.readLine(); // 파일 읽기(한줄씩);    파일의 끝이면 null리턴 
			if(line == null){
				break;
			}
			out.println(line + "<br>");
		}
	}catch(Exception e){
		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다.");
	}finally{
		try{
			if(br != null) br.close();
		}catch(Exception e){
			
		}
	} */
	
%>	
	
	
</body>
</html>





























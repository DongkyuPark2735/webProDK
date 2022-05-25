<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer = "4kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h2>버퍼의 크기 : <%=out.getBufferSize()%>  </h2>
  <h2>버퍼의 남은 크기 : <%=out.getRemaining()%>  </h2>
  <%
  for(int i =0; i<1000; i++){
	  out.print("<h2>테스트함 : i = "+i + "번째에서 남은 버퍼 크기 : "+out.getRemaining()+"<br>");
/* 	  println이랑 컴파일과정에서 자바에서 /n추가되는 차이? */
  }
  %>
</body>
</html>
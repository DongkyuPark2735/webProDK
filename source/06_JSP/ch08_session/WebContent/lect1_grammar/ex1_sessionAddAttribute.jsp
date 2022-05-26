<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
<script type="text/javascript">
	Selection()
</script>
</head>
<body>
	<%//세션에 속성 추가(객체타입으로 추가)
		session.setAttribute("sessionName", "sessionValue");// 첫번째 매개변수 세션이름 객체 스트링 형만 , 두번째 매개변수는 데이터(값)
		session.setAttribute("myNum", 123);	 //기초데이터타입도 들어갈순 있음 
		//session.setAttribute("myNum",new Integer(123)); 래퍼클래스로 변화된어 들어감 
	%>  
	<h1>세션에 sessionName 속성 추가</h1>
	<h1>세션에 myNum 속성 추가</h1>
	<a href="ex2_sessionGet.jsp">세션 GET</a>
</body>
</html>
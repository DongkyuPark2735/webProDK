<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
	  <!-- ex1_forward.jsp?n=1로 요청  ?n=1 ?는 다음에 매개변수가 있다는 뜻 1은 문자 -->
	<h2>ex1_forward.jsp 페이지 입니다.</h2>
	<jsp:forward page="ex2_forward.jsp"/> <!-- 표준액션태그 jsp표준 액션태그는 꼭 /닫아줘야한다 -->
	
	
	<%-- <%
	String n = request.getParameter("n");// 파라미터 전달해서 전송할때는 jsp:forward로
	response.sendRedirect("ex2_forward.jsp"); %>   --%>
					<!-- 기존걸버리고 리퀘스트 객체 새로 만들어지기 때문에  매개변수의 값이 전달안됨. -->
	<!-- 리퀘스트 객체를 없애지않고 페이지 요청    re 는 페이지 없애고 요청? -->
</body>
</html>
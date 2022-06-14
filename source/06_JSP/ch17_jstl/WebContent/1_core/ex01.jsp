<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--prefix 전치사 설정 보통 c로  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
  <h2>core 라이브러리</h2>
  <c:forEach var="i" begin="1" end="3" step="1"> <!-- 1부터 3까지 1개씩 foreach문 안 태그 진행 -->
  	<!-- 변수 설정 할수있고 el로 출력  -->
  	<p>${i}번쨰, 안녕하세요 </p>
  </c:forEach>
	<%
		for(int i=1; i<=3; i++){
			out.println("<p>"+i+"번째, 안녕하세요</p>");
		}
	%>
	
	<h2>fmt(formatting) 라이브러리</h2>
		<fmt:formatNumber value="3333.141592" pattern="#,###.00"/>
		<h2>그외 라이브러리 (functions 라이브러리)</h2><!--fn라이브러리는 el표기법과 함께 사용  -->
		ID파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
</body>
</html>
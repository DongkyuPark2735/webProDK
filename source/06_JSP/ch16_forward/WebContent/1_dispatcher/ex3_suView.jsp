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
  <h2>ex3_suView.jsp페이지 입니다.</h2>
  <h3>1부터 ${param.su }까지 누적합은 ${requestScope.sum }</h2><!--requestScope 생략 가능  -->
  <button onclick="history.back()">이번</button>
  <button onclick="<%=conPath %>/history.back()">이번</button>
</body>
</html>
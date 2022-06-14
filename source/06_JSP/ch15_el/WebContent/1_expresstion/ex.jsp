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
	<h2>표현식() 태그 이용</h2> <!--  에러 -->  
  
	<p>산술연산 : 10+1 = <%= 10+1 %></p>
	<p>산술연산 : 10/0.0 = <%= 10/0.0 %></p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => <%= 1==2 %></p>
	<p>관계연산 : 1!=2 => <%= 1!=2 %></p>
	<p>관계연산 : 1<2 => <%= 1<2 %></p>
	<p>관계연산 : 1&lt;2 => <%= 1<2 %></p>
	<p>조건연산 : <%= (1>2)? "1이 2보다 큽니다.":"1이 2보다 크지않습니다." %>
	<p>논리연산 : (1>2)||(1<2) = <%= (1>2)||(1<2) %></p>
	<p>로그인 여부 <%= session.getAttribute("customer")==null ? "로그인전":"로그인후" %>
	<p>로그인 여부 <%= session.getAttribute("customer")!=null ? "로그인후":"로그인전" %>
	<p>pageNum 파라미터 여부<%= request.getParameter("pageNum")== null? "pageNum 존재안함":"pageNum 존재" %>
	<p>name 파라미터 : <%=request.getParameter("name").toUpperCase() %></p>


	<h2>EL표기법을 이용한(표현식 안에 쓸 수 있는 연산자는 다 사용가능)</h2>
	
	<p>산술연산 : 10+1 = ${10+1 }</p><!--스페이스 한공간 남길것?  -->
	<p>산술연산 : 10/0.0 = ${ 10/0.0 }</p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => ${ 1 eq 2 }</p>
	<p>관계연산 : 1!=2 => ${ 1!=2 }</p>
	<p>관계연산 : 1<2 => ${ 1<2 }</p>
	<p>관계연산 : 1&lt;2 => ${ 1<2 }</p>
	<p>조건연산 : ${ (1>2)? "1이 2보다 큽니다.":"1이 2보다 크지않습니다." }</p>
	<p>논리연산 : (1>2)||(1<2) = ${ (1>2)||(1<2) }</p>
	<p>로그인 여부 ${customer==null ? "로그인전":"로그인후" }</p> <!-- 세션스콥?에 있는 변수 -->
	<p>로그인 여부 ${customer eq null ? "로그인전":"로그인후" }</p> <!-- 세션속성 바로쓸수있음? 셔센 내장객체 el에서는 없음  세션스콥은 생략가능 세션스콥은 el에서만 -->
	<p>로그인 여부 ${empty customer ? "로그인전":"로그인후" }</p> <!-- 스크립틀립에서 만 쓸수있는 세션 내장객체 -->
	<p>로그인 여부 ${not empty customer ? "로그인후":"로그인전" }</p>
	
	<p>pageNum 파라미터 여부 ${empty param.pageNum ? "pageNum 존재안함":"pageNum 존재" }</p>
	<p>name 파라미터 : ${ param.name }</p>
	<p>name 파라미터 대문자로 : ${ param.name.toUpperCase() }</p> <!-- param은 파라미터 없어도 예외 발생 안함   -->

	<!-- 파라미터로 들어오는 객체들은 param에 다 붙음? -->
	
		
	

</body>
</html>






















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<table>
		<caption>직원 정보</caption>
		<tr>
			<th>사번</th>
			<td>${empDto.empno }</td>	
		</tr>
		<tr>
			<th>이름</th>
			<td>${empDto.ename }</td>	
		</tr>
		<tr>
			<th>업무</th>
			<td>${empDto.job }</td>	
		</tr>
		<tr>
			<th>상사사번</th>
			<td>${empDto.mgr }</td>	
		</tr>
		<tr>
			<th>입사일</th>
			<td>
				<fmt:formatDate value="${empDto.hiredate}" pattern="yy년 MM월 dd일 (E)"/>
			</td>	
		</tr>
		<tr>
			<th>급여</th>
			<td>${empDto.sal}</td>	
		</tr>
		<tr>
			<th>상여</th>
			<td>${empDto.comm }</td>	
		</tr>
		<tr>
			<th>부서번호</th>
			<td>${empDto.deptno }</td>	
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location='${conPath}/empDeptList.do?pageNum=${param.pageNum}'">목록</button>
				<button onclick="location='updateView.do?empno=${empDto.empno}&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location='delete.do?empno=${empDto.empno}&pageNum=${param.pageNum}'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>




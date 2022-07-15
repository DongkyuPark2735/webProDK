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
</head>
<body>
	<h3>현재 총 ${totCnt }명</h3>
	<form action="${conPath }/quizInput.do" method="get">
		<table>
      <caption>개인 정보 입력</caption>		
			<tr>
				<td>이름 : </td>
				<td>${student2VO.qname }</td>
			</tr>
			<tr>
				<td>국어 : </td>
				<td>${student2VO.qkor }</td>
			</tr>
			<tr>
				<td>영어 : </td>
				<td>${student2VO.qeng }</td>
			</tr>
			<tr>
				<td>수학 : </td>
				<td>${student2VO.qmat }</td>
			</tr>
			<tr>
				<td>총점 : </td>
				<td>${sum }</td>
			</tr>
			<tr>
				<td>평균 : </td>
				<td>
					<fmt:formatNumber value="${avg }" pattern=".00"></fmt:formatNumber>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="뒤로가기" onclick="history.back()" >
					<input type="submit" value="다시입력" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
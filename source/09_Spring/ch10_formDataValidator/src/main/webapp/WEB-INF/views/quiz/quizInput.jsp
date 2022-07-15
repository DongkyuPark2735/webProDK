<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<form action="${conPath }/quizInput.do" method="post">
		<table>
      <caption>개인 정보 입력</caption>		
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="qname"></td>
			</tr>
			<tr>
				<td>국어 : </td>
				<td><input type="number" name="qkor"></td>
			</tr>
			<tr>
				<td>영어 : </td>
				<td><input type="number" name="qeng"></td>
			</tr>
			<tr>
				<td>수학 : </td>
				<td><input type="number" name="qmat"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="입력" >
				</td>
			</tr>
		</table>
		<h4>${nameError }</h4>
		<h4>${qkorError }</h4>
		<h4>${qengError }</h4>
		<h4>${qmatError }</h4>
	</form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

	<form action="${conPath }/mvcboard/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bgroup" value="${bdto.bgroup }">
		<input type="hidden" name="bstep" value="${bdto.bstep }">
		<input type="hidden" name="bindent" value="${bdto.bindent }">
		<table>
			<caption>${param.bid }번글의 답글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="btitle" required="required" value="[답]${bdto.btitle }">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn"> 
					<input type="button" value="목록" onclick="location.href='${conPath}/mvcboard/list.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
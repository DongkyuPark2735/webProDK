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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<form action="${conPath }/boardModify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bid" value="${param.bid }">
		<table>
			<caption>${param.bid }번 글 수정</caption>
			<tr>
				<th>글번호</th>
				<td>
					<input type="text" value="${bdto.bid }"	readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="bname" value="${bdto.bname }">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="btitle" value="${bdto.btitle }">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" cols="5" name="bcontent">${bdto.bcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="btn">
					<input type="reset" value="취소" onclick="history.back()" class="btn">
					<input type="button" value="목록" onclick="location.href='${conPath }/mvcboard/list.do?pageNum=${param.pageNum }'" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
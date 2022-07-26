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
<style>
	#content {
		width: 800px; height:600px;
		margin: 50px auto;
	}
	img{width: 100px;}
</style>
</head>
<body>
	<c:if test="${not empty emptybookModifyResult }">
		<c:if test="${emptybookModifyResult eq 1}">
			<script>
				alert('수정 성공');
			</script>
		</c:if>
		<c:if test="${emptybookModifyResult != 1}">
			<script>
				alert('수정 실패');
				history.back();
			</script>
		</c:if>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>${bookModel.bnum } 도서상세보기</caption>
			<tr>
				<th>글제목</th>
				<td>${bookModel.btitle }</td>
			</tr>		
			<tr>
				<th>글쓴이</th>
				<td>${bookModel.bwriter }</td>
			</tr>		
			<tr>
				<th>출판일</th>
				<td>${bookModel.brdate }</td>
			</tr>		
			<tr>
				<th>도서 이미지1</th>
				<td>
					<img alt="이미지1" src="${conPath }/bookImgFileUpload/${bookModel.bimg1 }">
				</td>
			</tr>		
			<tr>
				<th>도서 이미지2</th>
				<td>
					<img alt="이미지2" src="${conPath }/bookImgFileUpload/${bookModel.bimg2 }">
				</td>
			</tr>		
			<tr>
				<th>도서 정보</th>
				<td>${bookModel.binfo }</td>
			</tr>
			<tr>		
				<td colspan="2">
					<input type="button" value="목록으로" onclick="location.href='${conPath}/book.do?method=list&pageNum=${pageNum }'">
					<input type="button" value="수정하기" onclick="location.href='${conPath}/book.do?method=modify&pageNum=${pageNum }&bnum=${bookModel.bnum }'">
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>




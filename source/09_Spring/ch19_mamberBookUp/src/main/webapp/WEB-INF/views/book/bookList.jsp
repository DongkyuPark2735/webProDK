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
<style>
#content {
	width: 800px;
	height: 600px;
	margin: 50px auto;
}
img {
	width: 100px;
}
a {
	text-decoration: none;
	color: black;
}
b {
	color: red;
}
</style>
</head>
<body>
<c:if test="${not empty registerResult }">
	<c:if test="${registerResult eq 1 }">
		<script>
			alert("도서 등록 완료");
		</script>
	</c:if>
	<c:if test="${registerResult != 1 }">
		<script>
			alert("도서 등록 실패");
			history.back();
		</script>
	</c:if>
</c:if>

	<jsp:include page="../main/header.jsp" />
	<div id="content">
	<form action="${conPath }/book.do?method=searchList">
		<select name="bsearch">
			<option disabled="disabled" selected="selected">검색조건</option>
			<option value="both" 
				<c:if test="${param.bsearch eq 'both'}">
					selected="selected"	
				</c:if>>책이름+저자</option>
			<option value="bookOnly"
				<c:if test="${param.bsearch eq 'bookOnly'}">
					selected="selected"	
				</c:if>>책이름</option>
			<option value="writerOnly"
				<c:if test="${param.bsearch eq 'writerOnly'}">
					selected="selected"	
				</c:if>>저자</option>
		</select>
		<input type="text" value="${param.searchStr }" name="searchStr">
		<input type="submit" value="검색">
	</form>
		
		<table>
			<caption>도서 리스트</caption>
			<tr>
				<c:forEach var="book" items="${bookList }">
					<td>${book.btitle }<br> 
						<a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=1">
						<img src="${conPath }/bookImgFileUpload/${book.bimg1}">
					</a><br> ${book.bwriter } 著 <br> 출판일 : ${book.brdate }
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div class="paging" style="width : 500px; text-align: center; margin: 0 auto;
															height : 200px; line-height: 200px;" >
		<c:if test="${paging.startPage > paging.blockSize }">
			[<a href="${conPath}/book.do?method=list&pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }"	end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[<b>${i}</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[<a href="${conPath }/book.do?method=list&pageNum=${i }">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[<a href="${conPath }/book.do?method=list&pageNum=${paging.endPage+1 }">다음</a>]
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>

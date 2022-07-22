<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function () {
		
	});
	function trclicked(bid) {
		location.href='${conPath }/boardContent.do?bid='+bid+'&pageNum=${paging.currentPage }';
	}		
</script>
</head>
<body>
	<c:if test="${boardWriteResult eq 1}">
		<script>
			alert('글 작성 성공');
		</script>
	</c:if>
	<c:if test="${boardWriteResult eq 0}">
		<script>
			alert("글 작성 실패")
			history.back();
		</script>
	</c:if>

	<c:if test="${boardDeleteResult eq 1}">
		<script>
			alert('글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${boardDeleteResult eq 0}">
		<script>
			alert("글 삭제 실패")
			history.back();
		</script>
	</c:if>

	<c:if test="${insertReplyResult eq 1}">
		<script>
			alert('답글 작성 성공');
		</script>
	</c:if>
	<c:if test="${insertReplyResult eq 0}">
		<script>
			alert("답글 작성 실패")
			history.back();
		</script>
	</c:if>

	<table>
		<tr>
			<td><a href="${conPath}/boardWriteView.do">글쓰기</a></td>
		</tr>
	</table>

	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>ip</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr>
				<th colspan="7">등록된 글이 없습니다.</th>
			</tr>
		</c:if>

		<c:if test="${totCnt != 0 }">
			<c:forEach items="${myboardList }" var="bdto">
				<tr onclick="trclicked(${bdto.bid})">
					<td>${bdto.bid }</td>
					<td>${bdto.bname }</td>

					<td class="left"><c:forEach var="i" begin="1"
							end="${bdto.bindent }">
							<c:if test="${i == bdto.bindent }">
							-
						</c:if>
							<c:if test="${i != bdto.bindent }">
						 &nbsp; &nbsp; &nbsp; 
						</c:if>
						</c:forEach> ${bdto.btitle }</td>
					<td>${bdto.bip }</td>	
					<td><fmt:formatDate value="${bdto.bdate }"
							pattern="yy/MM/dd(E) hh:mm:ss(a)" /><br> <fmt:formatDate
							value="${bdto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)" /></td>
					<td><fmt:formatNumber value="${bdto.bhit }"	groupingUsed="true" /></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[<a href="${conPath}/boardList.do?pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[<b>${i}</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[<a href="${conPath }/boardList.do?pageNum=${i }">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[<a href="${conPath }/boardList.do?pageNum=${paging.endPage+1 }">다음</a>]
		</c:if>
	</div>
</body>
</html>
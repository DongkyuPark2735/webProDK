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
	<script>
		$(document).ready(function() {
// 			$('tr').click(function() {
// 				 var bid = Number($(this).children().eq(2).text());
// 				 if(!isNaN(bid))
// 				 //alert(bid);
// 				 location.href='${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}';
// 			});
		});
		//내부에 하면 내부함수라 호출불가능??	
		function trclicked(bid) {
			location.href='${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}';
		}		
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글쓰기 성공 / 실패 alert -->
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert("글쓰기 성공");
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL}">
		<script>
			alert("글쓰기 실패");
			history.back();
		</script>
	</c:if>
		
	<!-- 글수정 성공 / 실패 alert -->	
	<!-- 글삭제 성공 / 실패 alert -->	
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert(${param.bid }+"글삭제 성공");
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL}">
		<script>
			alert("${param.bid }글삭제 실패");
			history.back();
		</script>
	</c:if>
	
	<!-- 글답변 성공 / 실패 alert -->
	<c:if test="${replyResult eq SUCCESS }">
		<script>
			alert("답글 작성 성공");
		</script>
	</c:if>
	<c:if test="${replyResult eq FAIL}">
		<script>
			alert("답글 작성 실패");
			history.back();
		</script>
	</c:if>

	<c:set var="ordNum" value="${orderNuum }"/> 
	<!-- 철자 다르게해야함? 숫자증가시 구분 못함 -->
	<c:set var="invNum" value="${inverseNum }"/> 
	<table>
		<tr>
			<td><a href="${conPath}/mvcboard/writeView.do">글쓰기</a></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th>순번</th>
			<th>역순</th>
			<th>글번호</th>
			<th>글쓴이</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>	
	<c:if test="${totCnt eq 0 }">
		<tr><th colspan="7">등록된 글이 없습니다.</th></tr>
	</c:if>
	
	<c:if test="${totCnt != 0 }">
		<c:forEach items="${boardList }" var="bdto">
			<tr onclick="trclicked(${bdto.bid})">
				<td>${ordNum }</td>
				<td>${invNum }</td>
				<td>${bdto.bid }</td>
				<td>${bdto.bname }</td>
				
				<td class="left">
					<c:forEach var="i" begin="1" end="${bdto.bindent }">
						<c:if test="${i == bdto.bindent }">
							-
						</c:if>
						<c:if test="${i != bdto.bindent }">
						 &nbsp; &nbsp; &nbsp; 
						</c:if>
					</c:forEach>
					${bdto.btitle }
				</td>
				<td>
					<fmt:formatDate value="${bdto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/><br>
					<fmt:formatDate value="${bdto.date }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
				</td>
				<td><fmt:formatNumber value="${bdto.bhit }" groupingUsed="true" /></td>
			</tr>	
			<c:set var="ordNum" value="${ordNum + 1}"/>
			<c:set var="invNum" value="${invNum - 1}"/>
		</c:forEach>
	</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage >BLOCKSIZE }">
			[<a href="${conPath}/mvcboard/list.do?pageNum=${startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[<b>${i}</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[<a href="${conPath }/mvcboard/list.do?pageNum=${i }">${i }</a>]
			</c:if>
		</c:forEach>		
		<c:if test="${endPage < pageCnt }">
			[<a href="${conPath }/mvcboard/list.do?pageNum=${endPage+1 }">다음</a>]
		</c:if>
	</div>
</body>
</html>














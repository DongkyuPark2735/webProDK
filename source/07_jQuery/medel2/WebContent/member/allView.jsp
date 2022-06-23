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

<style></style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<jsp:include page="/main/header.jsp" />
	<table>
		<caption>회원 리스트</caption>
		<c:set var="i" value="1"/>
		<c:if test="${empty mAllView }">
			<tr>
				<td>
					등록된 회원이 없습니다.
				<td>
			</tr>
		</c:if> 
		<c:if test="${not empty mAllView }">
		  <tr>
			 <c:forEach var="member" items="${mAllView}" >
					<td>
						<img src="${conPath}/memberPhotoUp/${member.mphoto}" alt="사진" width="250" height="250"><br>
						${member.mname}<br>
						(${member.mid})
					<td>
			 </c:forEach>
			<tr>
		</c:if>
	</table>
		<a href="${conPath }/allView.do?pageNum=1">&lt;&lt;</a>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage>BLOCKSIZE }">
			<a href="${conPath }/allView.do?pageNum=${startPage-1}">&lt;</a>
		</c:if>
		<c:if test="${startPage<=BLOCKSIZE }">
			&lt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${pageNum eq i }"> 
					[<b>${i}</b>]
				</c:if>		
				<c:if test="${pageNum != i }"> 
					[<a href="${conPath }/allView.do?pageNum=${i}">${i}</a>]			
				</c:if>		
			</c:forEach>

			&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage+1}">&gt;</a>
		</c:if>
		<c:if test="${endPage == pageCnt }">
			&gt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<a href="${conPath }/allView.do?pageNum=${pageCnt}">&gt;&gt;</a>

	<jsp:include page="/main/footer.jsp" />
</body>
</html>





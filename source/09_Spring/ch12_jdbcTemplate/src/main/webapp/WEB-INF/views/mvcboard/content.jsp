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
	<c:if test="${bdtoModifyResult eq 1}">
		<script>
			alert("수정 성공")
		</script>
	</c:if>
	<c:if test="${bdtoModifyResult eq 0}">
		<script>
			alert("수정 실패")
			history.back();
		</script>
	</c:if>

	<table>
		<caption>상세보기</caption>
		<tr><th>글번호</th><td>${bdto.bid}</td></tr>
		<tr><th>작성자</th><td>${bdto.bname}</td></tr>
		<tr><th>제목</th><td>${bdto.btitle}</td></tr>
		<tr><th>본문</th><td><pre>${bdto.bcontent }</pre></td></tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${bdto.bdate }" pattern="yy/MM/dd(E)"/>
		</td>
		<tr><th>IP</th><td>${bdto.bip }</td></tr>
		<tr><th>조회수</th><td>${bdto.bhit }</td></tr>
		<tr>
			<td colspan="2">
				<button onclick="location='${conPath}/mvcboard/modify.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location='${conPath}/mvcboard/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location='${conPath}/mvcboard/reply.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location='${conPath}/mvcboard/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>
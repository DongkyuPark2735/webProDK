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
<style>
#content {
	width: 800px;
	height: 350px;
	margin: 50px auto;
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${conPath }/js/address.js"></script>
</head>
<body>
	<c:if test="${modifyResult==0 }">
		<script>
			alert("정보 수정이 실패되었습니다");
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<form action="${conPath }/member.do" method="post">
			<input type="hidden" name="method" value="modify">
			<input type="hidden" name="mid" value="${memberModel.mid }">
			<table>
				<tr>
					<td>아이디</td>
					<td>${memberModel.mid }</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mpw" value="${memberModel.mpw }" required="required"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mname" value="${memberModel.mname }" required="required"></td>
				</tr>
				<tr>
					<td>메일</td>
					<td><input type="text" name="mmail" value="${memberModel.mmail }" required="required"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" id="sample4_postcode" name="mpost" class="text_box" value="${memberModel.mpost }">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" id="sample4_roadAddress" name="maddr" value="${memberModel.maddr }">
						<input type="hidden"	id="sample4_jibunAddress" name="X" placeholder="지번주소"> 
						<span	id="guide"></span></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>

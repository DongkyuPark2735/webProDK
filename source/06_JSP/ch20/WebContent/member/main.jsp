<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty loginFailMSG  }">
		<script>
			alert('${loginFailMSG}');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${not empty logOutMSG }">
		<script>
			alert('${logOutMSG}');
		</script>
	</c:if>
	
	<c:if test="${not empty modifyResult}">
		<script>
			alert('${modifyResult}');
		</script>
	</c:if>
	
	<c:if test="${not empty modifyErrorMsg}">
		<script>
			alert('${modifyErrorMsg}');
		</script>
	</c:if>
	
	<c:if test="${not empty deleteMSG}">
		<script>
			alert('${deleteMSG}');
		</script>
	</c:if>
	
	<c:if test="${not empty deleteFailMSG}">
		<script>
			alert('${deleteFailMSG}');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${not empty deleteSuccessMSG}">
		<script>
			alert('${deleteSuccessMSG}');
		</script>
	</c:if>
		
	<c:if test="${empty member }">
	  <h2>로그인 상태가 아닙니다.</h2>
	  <hr>
  	<input type="button" value="로그인" onclick="location.href='${conPath}/member/login.jsp'">
  	<input type="button" value="회원가입" onclick="location.href='${conPath}/joinView.do'">
  	<input type="button" value="전체회원보기" onclick="location.href='${conPath}/mAllView.do">
	</c:if>
	<c:if test="${not empty member }">
	  <h2>${member.mname }(${member.mid })님 어서오세요</h2>
	  <hr>
  	<input type="button" value="정보수정" onclick="location.href='${conPath}/modifyView.do'">
  	<input type="button" value="로그아웃" onclick="location.href='${conPath}/logout.do'">
  	<input type="button" value="전체회원보기" onclick="location.href='${conPath}/mAllView.do'">
	</c:if>
</body>
</html>
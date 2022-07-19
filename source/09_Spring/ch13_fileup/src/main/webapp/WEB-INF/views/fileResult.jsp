<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>파일 업로드 결과 : ${fileResult }</h2>
	<p>file1 : ${filenames[0] }<p>
	<p>file2 : ${filenames[1] }<p>
	<p>file3 : ${filenames[2] }<p>
	<!-- 공통요청경로 없으면 conPath 없어도됨? -->
	<c:if test="${not empty filenames[0]  }"><!-- 빈스트링도 empty로 -->
		<img src="upload/${filenames[0] }" width="400" height="400">
	</c:if>
	<c:if test="${empty filenames[0]  }">
		<h2>첫번째 첨부파일 첨부 안 함</h2>
	</c:if>
	<c:if test="${not empty filenames[1]  }">
		<img src="upload/${filenames[1] }" width="400" height="400">
	</c:if>
	<c:if test="${empty filenames[1]  }">
		<h2>두번째 첨부파일 첨부 안 함</h2>
	</c:if>
	<c:if test="${not empty filenames[2]  }">
		<img src="upload/${filenames[2] }" width="400" height="400">
	</c:if>
	<c:if test="${empty filenames[2]  }">
		<h2>세번쨰 첨부파일 첨부 안 함</h2>
	</c:if>
	
</body>
</html>
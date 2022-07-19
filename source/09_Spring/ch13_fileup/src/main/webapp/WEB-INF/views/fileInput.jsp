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
	<div align="center">
		<hr>
		<h2>파일 UPLOAD</h2>
		<hr>
		<!-- Spring API는 위에서부터 차곡차곡?  -->
		<form action="fileupload" method="post" enctype="multipart/form-data">
			<p>첨부파일1<input type="file" name="file1"></p>		
			<p>첨부파일2<input type="file" name="file2"></p>		
			<p>첨부파일3<input type="file" name="file3"></p>
			<input type="submit" value="전송">		
		</form>		
	</div>
</body>
</html>
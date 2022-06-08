<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>																										<!-- multipart를 쓸수있음 -->
	<form action="ex2_fileupPro3.jsp" method="post" enctype="multipart/form-data"> 
																<!-- 파일 첨부는 반드시 post방식으로    -->
																<!-- application/x-www-form-urlencoded타입은 파일 중복 허용안함? -->
		<p>파일1<input type="file" name="file1"><p>
		<p>파일2<input type="file" name="file2"><p>
		<p>파일3<input type="file" name="file3"><p>
		<input type="submit" value="파일업로드" class="btn">		
	</form>	
</body>
</html>
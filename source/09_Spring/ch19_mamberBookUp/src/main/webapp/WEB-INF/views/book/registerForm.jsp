<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
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
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
	  $("#datepicker").datepicker({
		  dateFormat : 'yy-mm-dd',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear : true,
			showOtherMonths : true,
			selectOtherMonths : false,
			yearSuffix : '년',
	  });
  } );
</script>

</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
	<form action="${conPath }/book.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="method" value="register">
		<table>
			<caption>도서 등록</caption>
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="btitle" required="required"> 
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>
					<input type="text" name="bwriter" required="required"> 
				</td>
			</tr>
			<tr>
				<th>출판일</th>
				<td>
					<input type="text" id="datepicker" name="brdate" required="required"> 
				</td>
			</tr>
			<tr>
				<th>도서 이미지1</th>
				<td>
					<input type="file" name="tmpbimg1"> 
				</td>
			</tr>
			<tr>
				<th>도서 이미지2</th>
				<td>
					<input type="file" name="tmpbimg2"> 
				</td>
			</tr>
			<tr>
				<th>도서 정보</th>
				<td>
					<textarea rows="10" cols="10" name="binfo">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록하기">
					<input type="reset" value="목록으로"	onclick="location.href='${conPath}/book.do?method=list&pageNum=${pageNum }'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
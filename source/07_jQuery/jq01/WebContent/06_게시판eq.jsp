<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('tr').click(function () {
				var no = $(this).children().eq(0).text();
				//alert(no);
				if(isNaN(Number(no))){
					alert('타이틀');
				}else{
					alert('상세보기페이지');
					location.href='03_toggle.jsp?no='+no;
				}
			});
		});
	</script>
</head>
<body>
	<table>
		<tr>
			<th>순번</th>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>
		<tr>
			<th>1</th>
			<th>4</th>
			<th>제목4</th>
			<th>홍사동</th>
			<th>44</th>
		</tr>
		<tr>
			<th>2</th>
			<th>3</th>
			<th>제목3</th>
			<th>홍삼동</th>
			<th>20</th>
		</tr>
		<tr>
			<th>3</th>
			<th>2</th>
			<th>제목2</th>
			<th>홍이동</th>
			<th>22</th>
		</tr>
		<tr>
			<th>4</th>
			<th>1</th>
			<th>제목1</th>
			<th>홍일동</th>
			<th>2</th>
		</tr>
	</table>
</body>
</html>
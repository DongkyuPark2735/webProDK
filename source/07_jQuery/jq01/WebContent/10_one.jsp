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
			$('h1').one('click', function () { // 한번만 수행 자동 제거됨
				$(this).append('<b>☞</b>').prepend('<b>☞</b>').css('color', 'green');
			});
			
// 			$('h1').click(function () {
// 				$(this).append('<b>☞</b>').prepend('<b>☞</b>').css('color', 'green');
// 				$(this).off();
// 			});
			
			
		});
	</script>
</head>
<body>
	<h1>BTS 좋아요는 한번만</h1>
	<h1>JSP 좋아요는 한번만</h1>
	<h1>JYP 좋아요는 한번만</h1>
	
</body>
</html>
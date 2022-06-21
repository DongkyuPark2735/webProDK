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
			$('img[alt="마우스 다운전"]').mousedown(function () {
				$(this).attr('src', 'img/but2.gif');
				$(this).attr('alt', '마우스 다운');
			});
			$('img').mouseup(function () {
				$(this).attr('src', 'img/but1.gif');
				$(this).attr('alt', '마우스 다운전');
			});
		});
	</script>
</head>
<body>
	<img alt="마우스 다운전" src="img/but1.gif">
</body>
</html>
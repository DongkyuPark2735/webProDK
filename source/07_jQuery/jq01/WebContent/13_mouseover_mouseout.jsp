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
// 			$('img').mouseover(function() {
// 				// over된 img의 src : img/?out.jpg => src를 img/?over.jpg
// 				var idx = $(this).attr('src').substring(4,5);
// 				$(this).attr('src', 'img/'+idx+'over.jpg');
// 			}); //mouseover 이벤트
// 			$('img').mouseout(function () {
// 				// over된 img의 src : img/?out.jpg => src를 img/?over.jpg
// 				var idx = $(this).attr('src').substring(4,5);
// 				$(this).attr('src', 'img/'+idx+'out.jpg');
// 			}); //mouseover 이벤트
			var outImg = ["img/0out.jpg","img/1out.jpg","img/2out.jpg","img/3out.jpg"];
			var overImg = ["img/0over.jpg","img/1over.jpg","img/2over.jpg","img/3over.jpg"];
			$('img').each(function(idx, item) {
				$(this).mouseover(function () {
					$(this).attr('src', overImg[idx]);
				});
				$(this).mouseoui\t(function () {
					$(this).attr('src', outImg[idx]);
				});
			}); 
		
		});
	</script>
</head>
<body>
	<img alt="" src="img/0out.jpg">
	<img alt="" src="img/1out.jpg">
	<img alt="" src="img/2out.jpg">
	<img alt="" src="img/3out.jpg">
</body>
</html>
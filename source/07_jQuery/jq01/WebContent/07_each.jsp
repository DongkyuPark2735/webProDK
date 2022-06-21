<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var array = [ {	name : '가메출판사', link : 'http://www.kame.co.kr'},
									{	name : '네이버', link : 'http://www.naver.com'},
									{	name : '다음', link : 'http://www.daum.net'},
									{	name : '구글',	link : 'http://www.google.com'} ];
		//var out = '';
		$.each(array, function (idx, item) { //첫번째는 순서, 두번째는 n번째 배열 받을 변수? 
						//첫번째는 배열, 두번째는 콜백함수
			//out += '<h1>TEST</h1>';
			$('body').html($('body').html()+'<h1><a href="'+item.link+'">'+item.name+'</h1>');
		
		});
		
		//$('body').html(out);
		//$(array).html();
	});
</script>
</head>
<body>

</body>
</html>
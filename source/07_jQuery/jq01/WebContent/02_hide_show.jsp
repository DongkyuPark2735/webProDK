<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
			$('p').click(function () {
				$(this).hide();
			});
			$('button#hideP1').click(function () {
				$('#p1').hide();
			});
			$('button#hidePtag').click(function () {
				$('p').hide('slow');
			});
			$('button#showPtag').click(function () {
				$('p').show('fast');
			});
		});

	</script>	
</head>
<body>
	<h1>이곳은 head</h1>
	<p>이 p태그를 클릭하면 숨겨짐</p>
	<p>이 p태그를 클릭하면 숨겨짐</p>
	<p id="p1">이것 p1하나도 숨겨짐</p>
	
	<button id="hideP1">p1하나 숨김</button>
	<button id="hidePtag">p태그 전체 숨김</button>
	<button id="showPtag">p태그 출력</button>
</body>
</html>


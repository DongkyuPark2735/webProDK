<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.red{
		color: red;
	}
	.blue{
		color: blue;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
				var h1HitCnt = 0;
				$('#h2').click(function () {
					$(this).prepend('<b class="red">☆</b>');
					$(this).append('<b class="blue">☆</b>');
				});
				$('#h1').click(function() {
				$('#h1').click(function() {
				$('#h1').click(function() {
				$('#h1').click(function() {
					h1HitCnt++;
					if(h1HitCnt <6){
						$(this).prepend('<b class="red">☆</b>');
						$(this).append('<b class="blue">☆</b>');
					}else{
						$('#h2').off(); // 이벤트제거    범위 어디까지 ?? $('#h2').off() 모든'#h2'함수제거 
					}
				});
				
				setInterval(function () {
					$('h1').trigger('click');//강제이벤트발생
				}, 2000);
		});
	</script>
</head>
<body>
	<h1 id="h1">start1</h1>
	<h1 id="h2">start2</h1>
</body>
</html>
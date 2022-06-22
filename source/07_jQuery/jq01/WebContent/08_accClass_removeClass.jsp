<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table td{
		width: 100px;
		height: 100px;
		background-color: #AAFFAA;
	}
	.tdRed{
		background-color: red;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('td').click(function () {
				alert('1');
				//$('td')on('click', function)
				$('td').removeClass('tdRed'); 
				$(this).addClass('tdRed');
				var no = $(this).attr('id');
				$('body').html($('body').html()+no+'번째'); // 스크립트까지 바뀜?
			});
		});
	</script>
</head>
<body>
	<table>
		<tr><!--  class 이름에 스페이스가 들어갈수 없는데 스페이스를 넣어서 여러 클래스 명 가능 -->
				<!--  id 명은 스페이스를 줄수가 없다 -->
			<td id="0"></td>
			<td id="1"></td>
		</tr>
		<tr>
			<td id="2"></td>
			<td id="3"></td>
		</tr>
	</table>
	<p></p>
</body>
</html>















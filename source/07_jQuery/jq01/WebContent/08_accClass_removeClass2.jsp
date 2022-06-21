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
			$('td').each(function (idx, item) { //td여러개라 배열임??
				$(this).click(function() {
					alert(idx + '번째 선택하셧군요');
					$('td').removeClass('tdRed');
					$(this).addClass('tdRed');
				});
			});
			
			
			/* $('td').click(function () {
				//$('td')on('click', function)
				$('td').removeClass('tdRed'); 
				$(this).addClass('tdRed');
				var no = $(this).attr('id');
			}); */
		});
	</script>
</head>
<body>
	<table>
		<tr><!--  class 이름에 스페이스가 들어갈수 없는데 스페이스를 넣어서 여러 클래스 명 가능 -->
				<!--  id 명은 스페이스를 줄수가 없다 -->
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>















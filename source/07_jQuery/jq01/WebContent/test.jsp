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
	img{
		width: 100px;
		height: 100px;
		margin: 0;
		padding: 0;
		z-index: -9999;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			var i = Math.ceil(Math.random()*9);
			
			$('td').on('click', function () {
				//var i = parseInt(Math.random()*9);

				$('td').css('backgroundColor', '#AAFFAA');
				$(this).css('backgroundColor', 'red');
				
				if(i == $(this).attr('id')){
					$('p').text('축하축하 맞췄어요');
					$('input').val('축하축하 맞췄어요 ');
					$("td[id='"+i+"']").html("<img src='img/dduk.jpg'>");
					//$('td').off();
				}else{
					$('p').text('거기가 아니에요 ');
					$('input').val('거기가 아니에요 ');
				}
				
			});
			$('td').mouseleave(function () {
				$('td').css('backgroundColor', '#AAFFAA');
				$("td").html(" ");
			})
		});
		
	</script>
</head>
<body>
	<h1>연습문제1. 떡이 있는 곳을 맞춰봐</h1>
	<table>
		<tr>
			<td id="0"></td>
			<td id="1"></td>
			<td id="2"></td>
		</tr>
		<tr>
			<td id="3"></td>
			<td id="4"></td>
			<td id="5"></td>
		</tr>
		<tr>
			<td id="6"></td>
			<td id="7"></td>
			<td id="8"></td>
		</tr>
	</table>
	<p>선택한 곳이 맞는 지 답 뿌리는 곳</p>
	<input type="text" value="선택한 곳이 맞는 지 답 뿌리는 곳">
	
</body>
</html>
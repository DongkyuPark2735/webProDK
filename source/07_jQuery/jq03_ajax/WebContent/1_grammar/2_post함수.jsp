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
			$('button').click(function() {
				var mid = $('input[name="mid"]').val();
						//(요청경로, 요청파라미터(객체스타일로 해야함?), 콜백)
				$.post('idConfirm1.jsp', {mid : mid, aaa : 'aa'}, function(data, status) {
				//post방식이라 url에 매개변수 실어서 못보냄	 
					if(status == 'success'){ //status값이 불린 
						$('#result').html(data);
					}	
				});
			});
			$('input[name="mid"]').keyup(function() {
				var mid = $('input[name="mid"]').val();
						//(요청경로, 요청파라미터(객체스타일로 해야함?), 콜백)
				$.post('idConfirm1.jsp', {mid : mid, aaa : 'aa'}, function(data, status) {
				//post방식이라 url에 매개변수 실어서 못보냄	 
					if(status == 'success'){ //status값이 불린? 
						$('#result').html(data);
					}	
				});
			});
			
		});
	</script>
</head>
<body>
	<p>
		아이디 <input type="text" name="mid" id="mid">
		<button>중복체크</button>
		<span id="result"></span>
	</p>
</body>
</html>
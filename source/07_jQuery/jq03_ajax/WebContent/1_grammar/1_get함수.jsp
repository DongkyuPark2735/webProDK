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
		$('#mid').keyup(function() {
			//$('button').click(function () { //idConfirm.jsp?mId=aaa
			var mid = $('#mid').val();
			//$.get(요청경로, callback(data, status){
			//	data : 요청경로의 수행 결과
			//  status : success / fail
			//})
			if (mid.length < 2) {
				$('#result').html('id는 2글자 이상입니다.');
			} else {
				$.get('idConfirm1.jsp?mid=' + mid, function(data, status) { // data body 다들어옴
					if (status == 'success') {
						$('#result').html(data);
					}
				});
			}
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
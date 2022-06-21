<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p:last-child() {
	padding-left: 30px;
  }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('input[name="pwchk"], input[name="pw"]').keyup(function() { //,로 선택자 추가
				var pw = $('input[name="pw"]').val(); //val() 매개변수가 있으면 넣어주고 없으면 값을 가져옴 
				var pwchk = $('input[name="pwchk"]').val(); 
				if(pw == pwchk){
					$('.result').text('비밀번호 일치');
				}else{
					$('.result').html('<b>비밀번호 불일치</b>');
				}
			}); //pw Check
			$('form').submit(function () {
				var resultMsg = $('.result').text().trim();
				if(resultMsg != '비밀번호 일치'){
					alert('비밀번호를 확인하세요');
					$('input[name="pw"]').val('');
					$('input[name="pwchk"]').val('');
					$('.result').html('');
					$('input[name="pw"]').focus();
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<form action="">
		<p>I &nbsp;D <input type="text" name="id"></p>
		<p>PW <input type="text" name="pw"></p>
		<p>PW <input type="text" name="pwchk"></p>
		<p class="result" > &nbsp; &nbsp; </p>
		<p><input type="submit" value="가입하기"></p>
	</form>
</body>
</html>
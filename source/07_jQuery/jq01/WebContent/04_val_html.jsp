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
			$('p#msg').html('<b>hello, jQuery</b>');
			//$('p#msg').text('<b>hello, jQuery</b>');
			//var msg = $('#msg').text(); // msg='<b>hello, jQuery</b>'
			var msg = $('#msg').text(); //  msg='hello, jQuery'
			$('input[name="msg"]').val('Hellom jQuery2');
			msg = $('input[name="msg"]').val();
			alert(msg);
		});
	</script>
</head>
<body>
	<p id="msg"></p>
	<p>메세지<input type="text" name="msg" value="msg"></p>
</body>
</html>














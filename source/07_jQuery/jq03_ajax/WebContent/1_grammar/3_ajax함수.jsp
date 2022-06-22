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
			$('button').click(function () {
				var mid = $('input[name="mid"]').val();
				$.ajax({
					//매개변수에 객체하나
					//url : 요청경로   *
					//data : 요청 파라미터 이름과 파라미터 값*
					//type : get방식/post방식 //기본값 get
					//datatype : html/json/.. 요청한 경로로 실행한 결과의 타입 //기본값 html
					// 								json은 객체배열로 받음 ??*
					//success : 성공시 수행할 콜백함수
					//error : 실패시 수행할 콜백함수
					url : 'idConfirm1.jsp',
					data : 'mid='+mid,
					type : 'get',
					dataType : 'html',
					success : function (data) {
						$('#result').html(data);
					},
					error : function (code) {
						alert(code.status + code.statusText);
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
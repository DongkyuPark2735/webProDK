<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({ //api안에 있는 속성을 넣어야함 
			 dateFormat: "yy-mm-dd",
			 changeMonth : true, // 월 선택바
			 monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //datepicker안에 객체로 들어가 있음 
		   showMonthAfterYear : true,
			 yearSuffix : '년', // "2020년 3월"
    	 showOtherMonths : true,
    	 dayNamesMin:['일','월','화','수','목','금','토'],
			 changeYear : true, //년을 바꿀수 있는 셀렉트 박스
			 minDate : '-100y',
			 yearRange : 'c-100:c+10',//셀렉트 박스에 표시될 년도
		});
	});
</script>
</head>
<body>
	<p>
		생년월일<input type="date">
	</p>
	<p>
		Date: <input type="text" id="datepicker">
	</p>
</body>
</html>
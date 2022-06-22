<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('input[name="mid"]').keyup(function () {
				var mid = $('input[name="mid"]').val();				
				$.ajax({
					url : '${conPath}/idConfirm.do',
					data : 'mid='+mid,
					type : 'get',
					dataType : 'html',
					success : function (data) {
						$('#idConfirmResult').html(data);	//특정부분만 값 가져올수있나
					}
				});
			});
			$('input[name="mpw"], input[name="mpwchk"]').keyup(function () {
					var mpw = $('input[name="mpw"]').val();				
					var mpwchk = $('input[name="mpwchk"]').val();				
					if(mpw == mpwchk){
						$('#pwChkResult').html('비밀번호 일치');
					}else{
						$('#pwChkResult').html('비밀번호 불일치');
					}	
			});
			
			$('form').submit(function() {
// 				var idConfirmResult = $('#idConfirmResult').text().trim();
				var pwChkResult = $('#pwChkResult').text().trim();
				var idConfirmResult = $('#idConfirmResult').text().trim();
				
				if(idConfirmResult != '사용가능한 ID입니다'){ // 한글 못가져옴??
					alert('사용 가능한 id로 기입하세요');
					$('#idConfirmResult').focus();
					return false;
				}else if(pwChkResult != '비밀번호 일치'){
					alert('비밀번호를 확인하세요');
					return false;
				}
								
			});
		});
	</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
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
			 maxDate: 'y',// 현재날짜 이전까지만 표시
			 yearRange : 'c-100:c+10',//셀렉트 박스에 표시될 년도 
		});
	});
</script>
</head>
<body>
	<form action="#">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mid" required="required">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<div id="idConfirmResult"> &nbsp;</div>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpwchk" required="required">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<div id="pwChkResult"> &nbsp;</div>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="text" name="mbirth" id="datepicker" >
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>







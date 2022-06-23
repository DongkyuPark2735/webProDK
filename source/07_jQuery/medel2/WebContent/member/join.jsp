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
<style></style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('input[name="mid"]').keyup(function () {
				var mid = $('input[name="mid"]').val();
				$.ajax({
					url: '${conPath}/idConfirm.do',
					data : 'mid='+mid,
					type : 'get',
					dataType : 'html',
					success : function (data) {
						$('#idConfirmResult').html(data);
					}
				});//id ajax
			});//id key up
			
			$('input[name="mpw"], input[name="mpwchk"]').keyup(function () {
				var mpw = $('input[name="mpw"]').val();
				var mpwchk = $('input[name="mpwchk"]').val();
				if(mpw==mpwchk){
					$('#pwChkResult').html('비밀번호 일치');
				}else{
					$('#pwChkResult').html('비밀번호 불일치');
				}
			});//pw key up

			$('input[name="memail"]').keyup(function () {
				var memail = $('input[name="memail"]').val();
				$.ajax({
					url: '${conPath}/emailChk.do',
					data : 'memail='+memail,
					type : 'get',
					dataType : 'html',
					success : function (data) {
						$('#emailChkResult').html(data);
					}
				});//email ajax
			});//email key up
			
			$('form').submit(function () {
				var idConfirmResult = $('#idConfirmResult').text().trim(); 
				var pwChkResult = $('#pwChkResult').text().trim(); 
				var emailChkResult = $('#emailChkResult').text().trim(); 
				if(idConfirmResult != '사용가능한 ID입니다'){
					alert('사용 가능한 id로 기입하세요');
					return false;
				}else if(pwChkResult != '비밀번호 일치'){
					alert('비밀번호가 일치하지 않습니다');
					return false;
				}else if(emailChkResult != '사용가능한 이메일'){
					alert('이메일 중복을 확인하세요');
					return false;
				}
				
			});// submit confirm
		});
	</script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({ 
				 dateFormat: "yy-mm-dd",
				 changeMonth : true, 
				 monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //datepicker안에 객체로 들어가 있음 
			   showMonthAfterYear : true,
				 yearSuffix : '년', 
	    	 showOtherMonths : true,
	    	 dayNamesMin:['일','월','화','수','목','금','토'],
				 changeYear : true, 
				 minDate : '-100y',
				 maxDate: 'y',
				 yearRange : 'c-100:c+10', 
			});
		});
	</script>
</head>
<link href="${conPath }/css/style.css" rel="stylesheet">
<body>
<jsp:include page="/main/header.jsp"/>
 <form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
  	<table>
  		<caption>회원가입</caption>
  		<tr>
  			<th>아이디</th>
  			<td>
  				<input type="text" name="mid" required="required">
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2"><div id="idConfirmResult"> </div></td>
  		</tr>
  		<tr>
  			<th>비밀번호</th>
  			<td><input type="password" name="mpw" required="required"></td>
  		</tr>
  		<tr>
  			<th>비밀번호확인</th>
  			<td><input type="password" name="mpwchk" required="required"></td>
  		</tr>
  		<tr>
  			<td colspan="2"><div id="pwChkResult"> </div></td>
  		</tr>
  		<tr>
  			<th>이름</th>
  			<td><input type="text" name="mname" required="required"></td>
  		</tr>
  		<tr>
  			<th>메일</th>
  			<td><input type="email" name="memail" ></td>
  		</tr>
  		<tr>
  			<td colspan="2"><div id="emailChkResult"> </div></td>
  		</tr>
  		<tr>
  			<th>사진</th>
  			<td><input type="file" name="mphoto"></td>
  		</tr>
  		<tr>
  			<th>생년월일</th>
  			<td><input type="text" name="mbirth" id="datepicker"></td>
  		</tr>
  		<tr>
  			<th>주소</th>
  			<td><input type="text" name="maddress"></td>
  		</tr>
  		<tr>
  			<td colspan="2">
			  	<input type="submit" value="회원가입"  >
			  	<input type="button" value="로그인" onclick="location='${conPath}/loginView.do'">
  			</td>
  		</tr>
  	</table>
  </form>
<jsp:include page="/main/footer.jsp"/>
</body>
</html>
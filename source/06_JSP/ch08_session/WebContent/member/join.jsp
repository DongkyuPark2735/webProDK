<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/Join.css" rel="stylesheet">
<script>
	function check() {
		if (frm.pw.value != frm.pwChk.value) {
			alert("비밀번호가 일치하지않습니다.");
			pwChk.focus();
			return false;
		}
		var hobby = document.querySelectorAll('input[name="hobby"]');
		var hobbyChk = 0;
		for (var i = 0; i < hobby.length; i++) {
			hobbyChk = hobbyChk + hobby[i].checked;
		}
		if (!hobbyChk) {
			alert('취미를 한개 이상 선택하셔야 합니다.');
			return false;
		}
	}
	
</script>
</head>
<body>
  <jsp:include page="header.jsp"/>
	<div id="wrap">
		<h1>회원가입</h1>
		<hr>
		
		<form action="joinPro.jsp" method="get" name="frm"
			onsubmit="return check()">
			<table>
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" id="name" name="name"
						required="required"></td>
				</tr>
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" id="id" name="id" required="required"></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호</label></td>
					<td><input type="password" id="pw" name="pw"
						required="required"></td>
				</tr>
				<tr>
					<td><label for="pwChk">비밀번호확인</label></td>
					<td><input type="password" id="pwChk" name="pwChk"
						required="required"></td>
				</tr>
				<tr>
					<td><label for="birth">생년월일</label></td>
					<td><input type="date" id="birth" name="birth"
						required="required"></td>
				</tr>
				<tr>
					<td><label>취미</label></td>
					<td>
						<input type="checkbox" name="hobby" value="book">독서
						<input type="checkbox" name="hobby" value="cook">요리 
						<input type="checkbox" name="hobby" value="exercise">운동
						<input type="checkbox" name="hobby" value="sleep">취침
					</td>
				</tr>
				<tr>
					<td><label>성별</label></td>
					<td><input type="radio" name="gender" value="m">남자 <input
						type="radio" name="gender" value="f">여자</td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="email" id="email" name="email"></td>
				</tr>
				<tr>
					<td><label>메일수신</label></td>
					<td><select name="mailcheck" multiple="multiple" size="3">
							<option>광고</option>
							<option>배송</option>
							<option>공지</option>
							<option>이벤트</option>
					</select></td>
				</tr>
			</table>
			<ul>
				<li><input type="submit" value="가입하기"></li>
				<li><input type="reset" value="다시하기"></li>
				<li><input type="button" value="뒤로가기" onclick="history.back()"></li>
			</ul>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>





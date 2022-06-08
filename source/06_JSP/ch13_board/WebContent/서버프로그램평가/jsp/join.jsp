<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/서버프로그램평가/css/style.css" rel="stylesheet">
<script src="<%=conPath%>/서버프로그램평가/js/join.js"></script>
</head>
<body>
	<form action="joinPro.jsp" method="post" name="join_frm">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="cid"></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="password" name="cpw"></th>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<th><input type="password" name="pwChk"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input type="text" name="cname"></th>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="ctel"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="cemail"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="caddress"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="cgender" value="m">남 
					<input type="radio" name="cgender" value="f">여
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tmpcbirth" value="yyyy-MM-dd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="가입하기"onclick="infoConfirm()">
					<input type="reset" value="다시하기">
					<input type="button" value="로그인" onclick="location.href='login.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>






















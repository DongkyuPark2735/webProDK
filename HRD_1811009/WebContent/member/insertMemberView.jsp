<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="<%=conPath %>/insertMember.do">
	<table>
		<caption>홈쇼핑 회원등록</caption>
		<tr>
			<th>회원번호(자동발생)</th>
			<td><input type="text" name="custno"></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="text" name="joindate"></td>
		</tr>
		<tr>
			<th>고객등급(A:VIP, B:일반, C:직원)</th>
			<td><input type="text" name="grade"></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="button" value="조회" onclick="">
			</td>
		</tr>
	</table>
 </form>
</body>
</html>
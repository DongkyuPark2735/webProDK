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
			
			
		});
	</script>
</head>
<link href="${conPath }/css/style.css" rel="stylesheet">
<body>
<jsp:include page="/main/header.jsp"/>
 <form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
  <input type="hidden" name="oldmphoto" value="${member.mphoto }">
  	<table>
  		<caption>정보수정</caption>
  		<tr>
  			<th>아이디</th>
  			<td>
  				<input type="text" name="mid" required="required" readonly="readonly"
  							 value="${member.mid} ">
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
  			<td colspan="2"><div id="pwChkResult"> </div></td>
  		</tr>
  		<tr>
  			<th>이름</th>
  			<td><input type="text" name="mname" required="required" value="${member.mname}"></td>
  		</tr>
  		<tr>
  			<th>메일</th>
  			<td><input type="email" name="memail" value="${member.memail}"></td>
  		</tr>
  		<tr>
  			<td colspan="2"><div id="emailChkResult"> </div></td>
  		</tr>
  		<tr>
  			<th>사진</th>
  			<td>
  				<input type="file" name="mphoto">
 					<img src="${conPath }/memberPhotoUp/${member.mphoto}" alt="사진"> 			
  			</td>
  		</tr>
  		<tr>
  			<th>생년월일</th>
  			<td><input type="text" name="mbirth" id="datepicker" value="${member.mbirth}"></td>
  		</tr>
  		<tr>
  			<th>주소</th>
  			<td><input type="text" name="maddress" value="${member.memail}"></td>
  		</tr>
  		<tr>
  			<td colspan="2">
			  	<input type="submit" value="수정"  >
			  	<input type="reset" value="취소" onclick="history.back();">
  			</td>
  		</tr>
  	</table>
  </form>
<jsp:include page="/main/footer.jsp"/>
</body>
</html>
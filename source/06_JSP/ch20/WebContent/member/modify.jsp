<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>									<!-- .do 경로 없을때 오류안남?  -->
  <form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
  	<input type="hidden" name="oldmphoto" value="${member.mphoto }">
  	<table>
  		<caption>정보수정</caption>
  		<tr>
  			<th>아이디</th>
  			<td><input type="text" name="mid" required="required" value="${member.mid }" readonly="readonly"></td>
  		</tr>
  		<tr>
  			<th>비밀번호</th>
  			<td><input type="password" name="mpw" required="required"></td>
  		</tr>
  		<tr>
  			<th>이름</th>
  			<td><input type="text" name="mname" required="required" value="${member.mname }"></td>
  		</tr>
  		<tr>
  			<th>메일</th>
  			<td><input type="email" name="memail" value="${member.memail }"></td>
  		</tr>
  		<tr>
  			<th>사진</th>
  			<td>																	<!-- input type file은 보안상이유로 기본값을 가질수 없음? -->
  				<input type="file" name="mphoto" value="${member.mphoto }">
  				<img alt="사진" src="${conPath }/memberPhotoUp/${member.mphoto }">
  			</td>
  		</tr>
  		<tr>
  			<th>생년월일</th>
  			<td><input type="date" name="mbirth" value="${member.mbirth }"></td>
  		</tr>
  		<tr>
  			<th>주소</th>
  			<td><input type="text" name="maddress" value="${member.maddress }"></td>
  		</tr>
  		<tr>
  			<td colspan="2">
			  	<input type="submit" value="정보수정" >
			  	<input type="button" value="회원탈퇴" onclick="location='${conPath}/mdeleteView.do'">
			  	<input type="reset" value="취소" onclick="history.back();">
  			</td>
  		</tr>
  	</table>
  </form>
</body>
</html>

















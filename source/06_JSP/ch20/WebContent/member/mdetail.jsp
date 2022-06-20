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
<body>
  	<table>
  		<caption>${detailMemeber.mname }(${detailMemeber.mid })님의 정보</caption>
  		<tr>
  			<th>아이디</th>
  			<td>${detailMemeber.mid }</td>
  		</tr>
  		<tr>
  			<th>이름</th>
  			<td>${detailMemeber.mname }</td>
  		</tr>
  		<tr>
  			<th>메일</th>
  			<td>${detailMemeber.memail }</td>
  		</tr>
  		<tr>
  			<th>사진</th>
  			<td>
  				<img alt="사진" src="${conPath }/memberPhotoUp/${detailMemeber.mphoto }">
  			</td>
  		</tr>
  		<tr>
  			<th>생년월일</th>
  			<td>${detailMemeber.mbirth }</td>
  		</tr>
  		<tr>
  			<th>주소</th>
  			<td>${detailMemeber.maddress }"</td>
  		</tr>
  		<tr>
  			<td colspan="2">
			  	<input type="button" value="목록상세보기" 
			  		     onclick="location='${conPath}/mAllView.do?pageNum=${pageNum }'">
  			</td>
  		</tr>
  	</table>
</body>
</html>

















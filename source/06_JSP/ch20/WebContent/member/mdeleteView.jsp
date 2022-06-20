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
<form action="${conPath }/mdelete.do" method="post">
  <input type="hidden" name="mid" value="${member.mid }">
  <table>
  	<caption>회원탈퇴</caption>
  	<tr>
  		<th>비밀번호</th>
  		<td>
  			<input type="password" name="mpw" required="required"> 
  		</td>
  	</tr>
  	<tr>
  		<td>
		  	<input type="submit" value="탈퇴" >
		  	<input type="reset" value="취소" onclick="history.back();"> 
  		</td>
  	</tr>
  </table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/bstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
  <form action="bookRegisterPro.jsp" method="post" enctype="multipart/form-data"> 
  	<!-- // get방식은 헤더에 스트링으로 파라미터만 넘긴다   헤더에 여러 정보가 같이 넘어감-->
  	<table>
  		<caption>책등록</caption>
			<tr>
				<th>책제목</th>
				<td><input type="text" name="btitle" maxlength="33" required="required"></td>	
			</tr>  		
			<tr>
				<th>책가격</th>
				<td><input type="number" name="bprice" min="0" max="9999999" required="required"></td>	
			</tr>  		
			<tr>
				<th>책이미지</th>
				<td><input type="file" name="bimage1"></td>	
			</tr>  		 <!-- filre형태는 자바빈 하려면 name 다르게 해서 받아야함 date형처럼  -->
			<tr>
				<th>책이미지</th>
				<td><input type="file" name="bimage2"></td>	
			</tr>  		
			<tr>
				<th>책 소개</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>	
			</tr>  		
			<tr>
				<th>할인율</th>
				<td><input type="number" name="bdiscount" min="0" max="100" value="0" required="required"></td>	
			</tr>  		
			<tr>
				<td colspan="2"><input type="submit" value="책등록" class="btn"><td>
  	</table>
  </form>
  	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
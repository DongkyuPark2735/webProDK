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
	<style>
		.paging, table{
			text-align: center;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<td><a href="${conPath }/member/main.jsp">메인으로</a></td>
		</tr>
	</table>
	<table>
		 <tr>
			 <c:set var="i" value="1" />
	 		 <c:forEach var="members" items="${list }">
				<td>
					<a href="${conPath }/mdetail.do?mid=${members.mid }&pageNum=${pageNum }">
					<img alt="사진" src="${conPath }/memberPhotoUp/${members.mphoto }"
						width="250px" height="250px" >
					</a>			
					<p>${members.mname }<br>
	   				 ${members.mid }</p>
				</td>
			 </c:forEach>
		 </tr>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
				[<a href="${conPath }/mAllView.do?pageNum=${startPage-1 }">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1"> 
			 <c:if test="${pageNum == i}">
				 [<a>${i }</a>]
			 </c:if>
			 <c:if test="${pageNum != i}">
				 [<a href="${conPath }/mAllView.do?pageNum=${i }">${i }</a>]
			 </c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt}">
				[<a href="${conPath }/mAllView.do?pageNum=${endPage+1 }">다음</a>]
		</c:if>
	</div>
  
</body>
</html>
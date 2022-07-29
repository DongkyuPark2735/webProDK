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
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').change(function() {
			$('form').submit();
		});
		$('input[type=text]').keyup(function() {
			$('form').submit();
		});
		  var value = $("input[name=ename]").val();
			$('input[name=ename]').focus().val('').val(value);
	});

</script>

</head>
<body>
	<div id="warp">
		<!-- action생략하면 현재요청경로로 -->
		<form action="" method="get">
			사원 <input type="text" name="ename" value="${schEmp.ename }" size="5">
			직책 <input type="text" name="job" value="${schEmp.job }" size="5">
			부서번호 
			<select name="deptno">
			 <option value="0">모든 부서</option>
			 <c:forEach items="${deptList }" var="dept">
				 <option value="${dept.deptno }" 
				  	<c:if test="${schEmp.deptno eq dept.deptno }">
				  		selected="selected"
				  	</c:if>
				  	>
				  	${dept.dname }
				 </option>
			 </c:forEach>
			</select>
		</form>
	<table>
		<tr>
			<th>사원번호</th>
			<th>이름 </th>
			<th>직책</th>
			<th>관리자</th>
			<th>입사일</th>
			<th>급여</th>
			<th>상여</th>
			<th>부서번호</th>
		</tr>
		 <c:forEach items="${empList }" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.mgr }</td>
				<td><fmt:formatDate value="${emp.hiredate }" pattern="yy년MM월dd일(E)"/></td>
				<td align="right"><fmt:formatNumber value="${emp.sal }" groupingUsed="ture" /></td>
				<td align="right"><fmt:formatNumber value="${emp.comm }" pattern="#,###" /></td>
				<td>${emp.deptno }</td>
			</tr>
		 </c:forEach>
	</table>
	</div>
</body>
</html>




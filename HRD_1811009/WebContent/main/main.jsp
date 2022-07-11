<%@page import="member_tbl_02.Member_tbl_02DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member_tbl_02.Member_tbl_02DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div>
		<table>
		<caption>회원 목록 조회/수정</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일지</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<tr>
				<%
					Member_tbl_02DAO mdao = Member_tbl_02DAO.getInstance();
					ArrayList<Member_tbl_02DTO> mdtoarr = mdao.listMember();
					for(Member_tbl_02DTO mdto : mdtoarr ){
					System.out.println(mdto);

				%>
					<td><%=mdto.getCustno()%></td>
					<td><%=mdto.getCustname() %></td>
					<td><%=mdto.getPhone() %></td>
					<td><%=mdto.getAddress() %></td>
					<td><%=mdto.getJoindate() %></td>
					<td><%=mdto.getGrade() %></td>
					<td><%=mdto.getCity() %></td>
					</tr>		
				<%		
					}
				%>
		</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
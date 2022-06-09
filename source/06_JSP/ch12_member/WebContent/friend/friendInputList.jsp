<%@page import="com.lec.friend.FriendDao"%>
<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
  	<form action="friendInputListPro.jsp" method="get">
  		<table>
				<tr>
					<th>친구이름</th>
					<td><input type="text" name="fname" required="required" ><input type="submit" value="추가"  >
																																	<input type="button" onclick="" value="검색"  ></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" name="ftel" required="required" ></td>
				</tr>
				<tr>
					<td colspan="2">
						<div>
							<p>이곳에 DB에 입력된 친구들 리스트</p>
							<%
								String fname = (String)session.getAttribute("fname");
							
							  if(fname==null)fname="";

								FriendDao fdao = FriendDao.getInstance();
								ArrayList<FriendDto> fList = fdao.searchFriends(fname);
						
								
								out.println("<table>");
								out.println("<tr><th>순번</th><th>이름</th><th>연락처</th></tr>");
								if(!fList.isEmpty()){
									for(FriendDto fdto : fList){
										out.println("<tr><th>"+fdto.getFno()+"</th><th>"+fdto.getFname()+
																"</th><th>"+fdto.getFtel()+"</th></tr>");
									}
								}else{
									out.println("<tr><th colspan=\"3\">해당 정보의 친구가 없습니다.</th><tr>");
								}
								out.println("<table>");
							%>
						</div>
					</td>
				</tr>
  		</table>
  	</form>
</body>
</html>
















<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- <link href = 'css/join.css' rel='stylesheet'> -->
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	*{
  		margin: 0;
  		padding: 0;
  	}
  	#wrap{
  		padding : 10px;
			width: 500px;
			border: 2px solid #7878E1;	
			margin : 0 auto;
			text-align: left;
		}
		h2{
			margin: 5px;
		}
		h2:first-child {
			text-align: center;
			color : #7878E1
		}
  </style>
</head>
<body>
   <div id="wrap">
   		<h2>회원가입정보</h2>
   		<hr>
   		<%
				String name = request.getParameter("name");
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String birth = request.getParameter("birth");
				Timestamp birth2 = null;
				if(birth != "") {
					birth2 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00"); // 스페이스 있어야함
				}
				String[] hobby = request.getParameterValues("hobby");// 배열 or null
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				String[] mailcheck = request.getParameterValues("mailcheck");
				Date joinDate = new Date(System.currentTimeMillis());
				String joinip = request.getRemoteAddr();
				
				out.println("<h2>name : "+name+"</h2>");
				out.println("<h2>id : "+id+"</h2>");
				out.println("<h2>pw : ");
				for(int i =0; i<=pw.length(); i++) {
					out.println("*");
				}
				out.println("</h2>");
				out.println("<h2>birth :" + birth + "</h2>");
				out.println("<h2>birth2: " +birth2 + "</h2>");
				out.println("<h2>hobby: ");
				if(hobby != null) {
					for(int i =0; i<hobby.length; i++) {
						if(i == hobby.length-1) {
							out.println(hobby[i]);					
						}else {
							out.println(hobby[i] + ",");					
						}
					}
				}
				out.println("</h2>");
				out.println("<h2> gender : " + gender+"</h2>");
				out.println("<h2> email : " + email+"</h2>");
				if(mailcheck!=null){
					out.println("<h2> mailSend :  " + Arrays.toString(mailcheck)+"</h2>");
				}else{
					out.println("<h2> mailSend : 모든 수신 거부</h2>");
				}
				out.println("<h2> 가입일 : " + joinDate+"</h2>");
				out.println("<h2> 가입ip : " + joinip+"</h2>");
   		%>
   </div>
   <%@ include file="footer.jsp"%>
	 <%out.close(); %>
</body>
</html>
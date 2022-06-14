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

	<%-- <%
		String id = request.getParameter("id");
		String[] pets = request.getParameterValues("pet");
		out.println("<h3>ID : "+id+"</h3>");
		out.println("<h3> 키우는  동물은 ");
		if(pets!=null){
			for(String pet : pets){
				out.println(pet + " ");
			}
		}else{
				out.println("없습니다.");
		}
		out.println("</h3>");
	%> --%>
	
	<h3>id : ${param.id}</h3>
	<h3>키우는 동물은 ${paramValues.pet[0] }
							 ${paramValues.pet[1] }
							 ${paramValues.pet[2] }
							 ${paramValues.pet[3] }
							 ${empty paramValues.pet ? "없습니다." : "" } 
	</h3>
</body>
</html>
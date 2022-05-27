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
<body><!-- id : 객체이름  , class는  클래스 패키지 범위 , 변수의 범위는 한 page 매배변수 없는 생성자 있어야함-->
			<!-- scope = 4가지 매개변수 있고 범위 설정  
			forward하면 request객체 생성안하고 넘기니 계속   -->  
			
  <jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
  <jsp:setProperty  name="p" property="name" value='<%=request.getParameter("name")%>'/> <!-- set메소드 호출 setter없으면 호출 안됨 -->
  <jsp:setProperty  name="p" property="age" value='<%=Integer.parseInt(request.getParameter("age"))%>'/> <!-- set메소드 호출 setter없으면 호출 안됨 -->
  <jsp:setProperty  name="p" property="gender" value='<%=request.getParameter("gender").charAt(0)%>'/>
  <jsp:setProperty  name="p" property="address" value='<%=request.getParameter("address")%>'/> 
  
  <h2>입력받은 개인정보</h2>
  <p>이름 <%=p.getName() %></p>
  <p>나이 <%=p.getAge() %></p>
  <p>성별 <%=p.getGender() %></p>
  <p>주소 <%=p.getAddress() %></p>
</body>
</html>
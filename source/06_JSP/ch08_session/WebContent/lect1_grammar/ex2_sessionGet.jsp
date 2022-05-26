<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//특정 세션 속성값 가져오기
	String sessionName = (String) session.getAttribute("sessionName"); //리턴타입이 object
	//session.setAttribute("sessionName", "sessionValue"); 
	Integer myNum = (Integer) session.getAttribute("myNum");
	// 웹브라우져가 닫히면 세션이 닫힌다. 
	out.println("sessionName : " + sessionName + "<br>");
	out.println("myNum : " + myNum + "<br>");
	out.println("id : " + session.getAttribute("id")+ "<br>");// 추가한 속성이 없을경우 null
	// 시스템이 자체적으로 세션에 데이터를 추가하진 않는다.
	
	// 모든세션 속성 리스트 출력
	out.println("<h4>모든 세션 속성들 list</h4>");
	Enumeration<String> sAttrNames = session.getAttributeNames();//리턴타입이 Enumeration이다 
	
	int cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement();// 세션(속성)이름
		String svalue = session.getAttribute(sname).toString(); // 세션(속성)값	
		out.println(sname+"(세션이름) / "+svalue+"(세션값)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가된 세션 속성이 없습니다.");
	}			
	//특정 세션(속성) 삭제하기(로그아웃시 사용)
	session.removeAttribute("myNum");// myNum 세션 속성삭제
	
	out.println("<h4>모든 세션 속성들 list</h4>");
	sAttrNames = session.getAttributeNames();  
	cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement();// 세션(속성)이름
		String svalue = session.getAttribute(sname).toString(); // 세션(속성)값	
		out.println(sname+"(세션이름) / "+svalue+"(세션값)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가된 세션 속성이 없습니다.");
	}				
	
	//모든 세션 삭제하기(로그아웃시 사용)
	session.invalidate(); // setAttribute 했던 모든 세션 속성값 다 삭제
	
	if(request.isRequestedSessionIdValid()){// 유효한 세션 속성이 있는지 여부
		out.println("session valid<br>");
	}else{
		out.println("session invalid<br>");
	}
	
	out.println("<h4>세션ID : "+session.getId()+"</h4>");
	out.println("<h4>세션의 유효시간 : "+session.getMaxInactiveInterval()+"</h4><br>"); // 톰켓 web.xml에 있는 시간 
	
	
	
	%>





</body>
</html>
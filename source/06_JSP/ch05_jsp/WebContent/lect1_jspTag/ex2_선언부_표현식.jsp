<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<%// 스크립트릿에서는 초기화 해줘야함 
	int j=0;
	i++; j++;
	strBuf.append("<span>♡</span>");
	out.println("strBuf = " + strBuf+"<br>");
	out.println("sum(5,2) = " + sum(5,2)+"<br>");
%>

	전역변수 i = <%=i %><br>
	지역변수 j = <%=j %><br>
	strBuf = <%=strBuf %>

	
	
<%!//선언부 먼저 해석하기때문에 위에 i쓸수있음
 	int i;// %! 초기화 하지않아도 초기화됨 숫자형은  0으로 초기화
 	StringBuffer strBuf = new StringBuffer("Good ");
 	public int sum (int a, int b){
 		return a+b;
 	}
%>
</body>
</html>



















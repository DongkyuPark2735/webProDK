<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- <%!
	int sum;
	int num;
%>
<% 
	if(num==0||request.getParameter("num")!=null){
		num = Integer.parseInt(request.getParameter("num"));
		for(int i = 1; i <= num; i++ ){
			sum += i;	
		}		
	}
	out.println("<h1>1부터 "+num+"까지의 누적합 "+sum+"</h1>");
%> --%>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script>
  	
  </script>
</head>
<body>
<%String num = request.getParameter("num");// null이거나 숫자스트링 %> 
  <fieldset>
  	<legend>숫자입력</legend>
			<form name="frm" action="" method="get" >
		<label for="num">숫자</label><input type="number" name="num" id="num" value="<%if(num!=null) out.print(num); %>" >
		<input type="submit" value="누적">   	
			</form>
  </fieldset>
	<%
	if(num!=null && !num.equals("")){
		int n = Integer.parseInt(num);
		int sum = 0;
		for(int i = 1; i <= n; i++ ){
			sum += i;	
		}		
		out.println("<h1>1부터 "+n+"까지의 누적합 "+sum+"</h1>");
	}
	%>
</body>
</html>
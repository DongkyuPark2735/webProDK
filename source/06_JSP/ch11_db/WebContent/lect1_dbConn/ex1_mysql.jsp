<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
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
<%!
	String driverMysql = "com.mysql.jdbc.Driver";
	String urlMysql = "jdbc:mysql://localhost:3306/kimdb"; 
  String uidMysql = "root";
  String upwMysql = "mysql";
%>
	<table>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSONAL"; // 컨트롤 쉬프트 x 컨트롤 슆프트 y
		try{
			Class.forName(driverMysql); // 1단계 : 드라이버 로드
			conn = DriverManager.getConnection(urlMysql, uidMysql, upwMysql); // 2단계 : db연결객체
			stmt = conn.createStatement(); // 3단계 : SQL 전송객체
			rs = stmt.executeQuery(sql); // 4단계(sql전송) + 5단계(전송결과 받기)
			if(rs.next()){//6단계
				out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th>");
				out.println("<th>급여</th><th>상여</th><th>부서번호</th></tr>");//타이틀
				do{
					int pno = rs.getInt("pno"); // db의 테이블 타이틀 이름과 같이 할것
					String pname = rs.getString("pname"); 
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					String startdate = rs.getString("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					out.println("<tr><td>"+pno+"</td><td>"+pname+"</td><td>"+job+"</td><td>"+manager);
					out.println("</td><td>"+startdate+"</td><td>"+pay+"</td><td>"+bonus+"</td><td>"+dno);
					out.println("</td></tr>");
				}while(rs.next());
			}else{
				out.println("<tr><td>입력된 데이터가 없습니다.</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());			
			}
		}
	%>
	</table>  
</body>
</html>









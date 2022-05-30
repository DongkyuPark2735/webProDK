<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	  String uid = "scott";
	  String upw = "tiger";
	  int deptno;
	  String dname;
	%>
   <form action="ex3_deptnoOut.jsp">
  	부서번호<select name="deptno">
  						<option value="0"></option>
  						<%
	  						Connection conn = null;
	  						Statement stmt = null;
	  						ResultSet rs = null;
	  						String sql = "SELECT * FROM DEPT";
	  						String deptnoStr = request.getParameter("deptno");
  							try{
  								Class.forName(driver);
  								conn = DriverManager.getConnection(url, uid, upw);
  								stmt = conn.createStatement();
  								rs = stmt.executeQuery(sql);
  								while(rs.next()){
  									deptno = rs.getInt("deptno");
  									dname = rs.getString("dname");
  									out.println("<option value="+deptno+">"+deptno+"-"+dname+"</option>");
  								};
  							}catch(Exception e){
  								System.out.println(e.getMessage());			
  							}finally{
  								if(rs!=null) rs.close();
  								if(stmt!=null) stmt.close();
  								if(conn!=null) conn.close();
  							}
  						%>
  				</select>
  			<input type="submit" value="검색">
  </form>
</body>
</html>
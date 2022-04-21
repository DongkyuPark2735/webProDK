package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SelectAllMySQL {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		String sql = "Select * from personal";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url, "root", "mysql");//2
			stmt = conn.createStatement();//3
			rs = stmt.executeQuery(sql); //4 +5 
			System.out.println();
			if(rs.next()){ // SELECT 문 결과가 있는경우
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
				do {
					int pno = rs.getInt("pno"); //숫자가 들어가면 해당번째 열
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
				}while(rs.next());
				
			}else { // SELECT 문 결과가 한행도 없는경우
				System.out.println("personal 데이터가 없습니다 ");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. 연결해제
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

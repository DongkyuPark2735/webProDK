package com.lec.ex3insert;

// 부서번호를 입력받아 중복체크 확인후 입력진행 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("입력할 부서번호는 ?"); // 자바로 넣으면 자동 commit
		int deptno = sc.nextInt();
		// 부서번호 중복체크
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO =" + deptno;
		String insertSQL;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			if(rs.getInt("cnt") != 0) {
				System.out.println("해당부서가 이미 존재합니다.");
			}else {
				System.out.println("입력할 부서명은 ?");
				String dname = sc.next();		
				
				System.out.println("입력할 부서위치는 ?");
				String loc = sc.next();
				insertSQL = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname,loc);
				int result = stmt.executeUpdate(insertSQL);
				if(result > 0) {
					System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				
				//contin
				
				}
			}
			
//			System.out.println(result > 0 ? "입력성공" : "입력실패");
//			System.out.println("입력할 부서명은 ?");
//			String dname = sc.next();
//			
//			System.out.println("입력할 부서위치는 ?");
//			String loc = sc.next();
//			
//			String sql = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname, loc);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 " + e.getMessage());
		} finally {
			try {
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

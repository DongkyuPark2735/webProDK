package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 부서번호는 ?"); // 자바로 넣으면 자동 commit
		int deptno = sc.nextInt();

		System.out.println("입력할 부서명은 ?");
		String dname = sc.next();

		System.out.println("입력할 부서위치는 ?");
		String loc = sc.next();

		String sql = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname, loc);
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력성공" : "입력실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 "+e.getMessage());
		}finally {
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

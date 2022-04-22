package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자로부터 삭제하고자 하는 부서번호를 입력받아 삭제하기
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null; //

		System.out.println("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;

		try {
			Class.forName(driver); // 1. 드라이버 생성
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2. 드라이버로드
			stmt = conn.createStatement(); // 3.
			int result = stmt.executeUpdate(sql); // select제외하고 다 update문으로
			System.out.println((result > 0) ? deptno + "번 삭제 성공" : deptno + " 번 부서는 존재하지않습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

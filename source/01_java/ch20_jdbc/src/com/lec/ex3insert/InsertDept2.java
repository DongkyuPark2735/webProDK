package com.lec.ex3insert;

// �μ���ȣ�� �Է¹޾� �ߺ�üũ Ȯ���� �Է����� 
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
		
		System.out.println("�Է��� �μ���ȣ�� ?"); // �ڹٷ� ������ �ڵ� commit
		int deptno = sc.nextInt();
		// �μ���ȣ �ߺ�üũ
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO =" + deptno;
		String insertSQL;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			if(rs.getInt("cnt") != 0) {
				System.out.println("�ش�μ��� �̹� �����մϴ�.");
			}else {
				System.out.println("�Է��� �μ����� ?");
				String dname = sc.next();		
				
				System.out.println("�Է��� �μ���ġ�� ?");
				String loc = sc.next();
				insertSQL = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname,loc);
				int result = stmt.executeUpdate(insertSQL);
				if(result > 0) {
					System.out.println("�Է¼���");
				}else {
					System.out.println("�Է½���");
				
				//contin
				
				}
			}
			
//			System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
//			System.out.println("�Է��� �μ����� ?");
//			String dname = sc.next();
//			
//			System.out.println("�Է��� �μ���ġ�� ?");
//			String loc = sc.next();
//			
//			String sql = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname, loc);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL���� " + e.getMessage());
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

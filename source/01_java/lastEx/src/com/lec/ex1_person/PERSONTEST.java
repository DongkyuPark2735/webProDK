package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PERSONTEST {
	public static void main(String[] args) {
		// �ʵ� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String insertSQL = "INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, ?, ?, ?,?,"
				+ "(SELECT JNO FROM JOB WHERE JNAME = ?) )";
		String selectSQL = "SELECT ROWNUM ���,PNAME, JNAME, KOR, ENG, MAT, TOT" + 
				" FROM( SELECT PNO, PNAME||'('||PNO||'��)' PNAME , JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT" + 
				" FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY TOT DESC)";
		int result, ok;
		// ��ü ����
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			do {
				System.out.println("��ȣ�� �Է��ϼ���  --1�� : �Է�  --2�� : ���� ���  --3:�� ��ü ���� ��� -- 0 = ����");
				ok = sc.nextInt();
				if (ok == 1) { //�Է�
					pstmt = conn.prepareStatement(insertSQL);
					System.out.println("�̸��� �Է��ϼ���");
					String pname = sc.next();
					pstmt.setString(1, pname);
					System.out.println("���� ������ �Է��ϼ��� ");
					int kor = sc.nextInt();
					pstmt.setInt(2, kor);
					System.out.println("���� ������ �Է��ϼ���");
					int eng = sc.nextInt();
					pstmt.setInt(3, eng);
					System.out.println("���� ������ �Է��ϼ��� ");
					int mat = sc.nextInt();
					pstmt.setInt(4, mat);
					System.out.println("������ �Է��ϼ���");
					String jname = sc.next();
					pstmt.setString(5, jname);
					result = pstmt.executeUpdate();
					System.out.println((result > 0) ? "�Է� ����" : "�Է� ����");
				} else if (ok == 2) {
					pstmt = conn.prepareStatement(selectSQL);
					System.out.println("��ȸ�Ϸ��� ������ �Է��ϼ���");
					String jname = sc.next();
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
					while(rs.next()) {
						int rownum = rs.getInt("���");
						String pname = rs.getString("pname");
						jname = rs.getString("jname");
						int kor = rs.getInt("kor");
						int eng = rs.getInt("eng");
						int mat = rs.getInt("mat");
						int tot = rs.getInt("tot");
						System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n",
								rownum, pname, jname,kor,eng,mat,tot);
					}
				}
			} while (ok != 0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
	}

}

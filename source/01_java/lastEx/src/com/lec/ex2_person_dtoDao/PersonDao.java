package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

//�Է�, ������ ��ȸ, ��ü ��ȸ, ��������Ʈ
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public static int SUCCESS = 1;
	public static int FAIL = 0;

	private static PersonDao INSTANCE;

	public static PersonDao getInstance() {// �̱������� ����
		if (INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}

	private PersonDao() {
		try {
			Class.forName(driver);// 1�ܰ�� �����ڿ��� �ѹ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 1�� �Է�(�Ű����� dto, return SUCCESS/FAIL)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// dto �ȿ� ���� DB�� insert(2~7�ܰ�)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON"
				+ " VALUES(PERSON_NO_SQ.NEXTVAL, ?, ?, ?,?,(SELECT JNO FROM JOB WHERE JNAME = ?) )";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setString(5, dto.getJname());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2�� ������ ��ȸ (�Ű����� jname, return PersonDto arrayList)
	public ArrayList<PersonDto> selectJname(String jname) { // list�ڷ�������
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// ������ ��ȸ����� dtos�� add(2~7�ܰ�)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM ���,PNAME, JNAME, KOR, ENG, MAT, TOT"
				+ " FROM( SELECT PNO, PNAME||'('||PNO||'��)' PNAME , JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT"
				+ " FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY TOT DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("���");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("tot");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 3�� ��ü��ȸ( return ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectALL() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// ��ü��ȸ ����� dtos�� add(2~7�ܰ�)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM ���, PNO, PNAME, JNAME, KOR, ENG, MAT, TOT"
				+ " FROM( SELECT PNO, PNAME, JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT"
				+ " FROM PERSON P, JOB J WHERE P.JNO=J.JNO ORDER BY TOT DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			PersonDto dto = new PersonDto(); ���� ���
			while (rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRank(rs.getInt("���"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("tot"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return dtos;
	}

	// 4�� ��������Ʈ ��ȸ(return Vector<String>)
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>();
		jnames.add(""); // 0��° index���� ""
		// ����������Ʈ�� DB���� �˻����� jname�� add (2~7)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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

		return jnames;
	}

}
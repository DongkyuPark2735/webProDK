package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// ���� �޺��ڽ�,�й��˻�, �̸��˻�, �����˻�, �л��Է�, �л�����, �л����, ������ ���, ����ó�� 
public class StudentDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public static int SUCCESS = 1;
	public static int FAIL = 0;

	private static StudentDAO INSTANCE;

	public static StudentDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDAO();
		}
		return INSTANCE;
	}

	public StudentDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// �а�����Ʈ���
	public Vector<String> getMnameList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		Vector<String> mNameList = new Vector<String>();
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mName = rs.getString("mname");
				mNameList.add(mName);
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
		return mNameList;
	}

	// �й��˻�
	public StudentDTO selectSno(int sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO stdto = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + " FROM STUDENT S, MAJOR M"
				+ " WHERE S.MNO = M.MNO AND SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				stdto = new StudentDTO(sno, sname, mname, score);
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
		return stdto;
	}

	// �̸� �˻�
	public ArrayList<StudentDTO> selectSname(String sname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + " FROM STUDENT S, MAJOR M"
				+ " WHERE S.MNO = M.MNO AND SNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sNo = rs.getInt("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sNo, sname, mname, score));
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

//	�����˻�
	public ArrayList<StudentDTO> selectMname(String mname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT ROWNUM R, A.*"
				+ " FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MAJOR, SCORE"
				+ " FROM MAJOR M, STUDENT S WHERE S.MNO = M.MNO AND MNAME = ? ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sNo = rs.getInt("R");
				String sname = rs.getString("name");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sNo, sname, mname, score));
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

	// �л��Է�
	public int insertStudent(StudentDTO pdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), ?,"
				+ " (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?, 0)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getSname());
			pstmt.setString(2, pdto.getMname());
			pstmt.setInt(3, pdto.getScore());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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

//	�л�����
	public int updateStudent(StudentDTO pdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "UPDATE STUDENT SET SNAME = ?, MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?),"
				+ " SCORE = ? WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getSname());
			pstmt.setString(2, pdto.getMname());
			pstmt.setInt(3, pdto.getScore());
			pstmt.setInt(4, pdto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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

//�л����	
	public ArrayList<StudentDTO> printStudent() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT ROWNUM R, A.*" + 
				" FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||S.MNO||')' MNAME, SCORE FROM STUDENT S, MAJOR M" + 
				" WHERE S.MNO = M.MNO AND EXPEL != 1 ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("R");
				String sname = rs.getString("NAME");
				String mname = rs.getString("MNAME");
				int score = rs.getInt("SCORE");
				dtos.add(new StudentDTO(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
//������ ���
	public ArrayList<StudentDTO> printExpelStudent() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT ROWNUM R, A.*" + 
				" FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||S.MNO||')' MNAME, SCORE FROM STUDENT S, MAJOR M" + 
				" WHERE S.MNO = M.MNO AND EXPEL != 0 ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("R");
				String sname = rs.getString("NAME");
				String mname = rs.getString("MNAME");
				int score = rs.getInt("SCORE");
				dtos.add(new StudentDTO(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
// ����ó��
	public int updateExpelStudent(int sNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "UPDATE STUDENT SET EXPEL = 1 "
				+ "WHERE SNO = ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
	
	
}

package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class CustomerDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static CustomerDAO INSTANCE;

	public static CustomerDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDAO();
		}
		return INSTANCE;
	}

	private CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//

	// -- 0. 레벨 이름들 검색 : Vector<String> getLevelNames()
	public Vector<String> getLevelNames() {
		Vector<String> levelNames = new Vector<>();
		levelNames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUSLEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				levelNames.add(rs.getString("levelname"));
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
		return levelNames;
	}

	// -- 1. 아이디 검색 : CustomerDTO cidGetCustomer( int )
	public CustomerDTO cIdGetCustomer(int cid) {
		CustomerDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,"
				+ " (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5) forLevelUp"
				+ " FROM CUSTOMER C, CUSLEVEL L" + " WHERE C.LEVELNO = L.LEVELNO AND CUSID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String ctel = rs.getString("custel");
				String cname = rs.getString("cusname");
				int cpoint = rs.getInt("cuspoint");
				int camount = rs.getInt("cusamount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forLevelUp");
				dto = new CustomerDTO(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
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
		return dto;
	}

	// -- 2. 폰4자리 검색 : ArrayList<CustomerDTO> cTelGetCustomer(String cTel);
	public ArrayList<CustomerDTO> cTelGetCustomer(String ctel) {
		ArrayList<CustomerDTO> ardto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,"
				+ " (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5) forLevelUp"
				+ " FROM CUSTOMER C, CUSLEVEL L" + " WHERE C.LEVELNO = L.LEVELNO AND CUSTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String tmpctel = rs.getString("custel");
				int cusid = rs.getInt("cusid");
				String cname = rs.getString("cusname");
				int cpoint = rs.getInt("cuspoint");
				int camount = rs.getInt("cusamount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forLevelUp");
				ardto.add(new CustomerDTO(cusid, tmpctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return ardto;
	}

	// -- 3. 고객 이름 검색 : ArrayList<CustomerDTO> cNameGetCustomer(String cName);
	public ArrayList<CustomerDTO> cNameGetCustomer(String cname) {
		ArrayList<CustomerDTO> ardto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,"
				+ " (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp"
				+ " FROM CUSTOMER C, CUSLEVEL L"
				+ " WHERE C.LEVELNO = L.LEVELNO AND CUSNAME = ? ORDER BY CUSAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String tmpctel = rs.getString("custel");
				int cusid = rs.getInt("cusid");
				int cpoint = rs.getInt("cuspoint");
				int camount = rs.getInt("cusamount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forLevelUp");
				ardto.add(new CustomerDTO(cusid, tmpctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return ardto;
	}

	// -- 4. 포인트로만 구매 : Int buyWithPoint(int cId, int cAmoint) (1번 ID가 100원 구매)
	public int buyWithPoint(int cid, int cpoint) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "UPDATE CUSTOMER SET CUSPOINT = CUSPOINT - ? WHERE CUSID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cpoint);
			pstmt.setInt(2, cid);
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

	// -- 5. 물품 구매 : int buy(int cId, int cAmount )
	public int buy(int cid, int camount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "UPDATE CUSTOMER SET CUSPOINT = CUSPOINT + (?*0.05), CUSAMOUNT = CUSAMOUNT + ?,"
				+ " LEVELNO = (SELECT L.LEVELNO 수정할레벨 " + " FROM CUSTOMER C, CUSLEVEL L"
				+ " WHERE CUSAMOUNT+? BETWEEN LOW AND HIGH AND CUSID = ?)" + " WHERE CUSID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
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

	// -- 6. 등급별 출력 : ArrayList<CustomerDTO> levelNameGetCustomer(String levelName)
	public ArrayList<CustomerDTO> levelNameGetCustomer(String levelname) {
		ArrayList<CustomerDTO> ardto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,"
				+ " (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5) forLevelUp"
				+ " FROM CUSTOMER C, CUSLEVEL L"
				+ " WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = ? ORDER BY CUSAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cusid = rs.getInt("cusid");
				String tmpctel = rs.getString("custel");
				String cname = rs.getString("cusname");
				int cpoint = rs.getInt("cuspoint");
				int camount = rs.getInt("cusamount");
				int forLevelUp = rs.getInt("forLevelUp");
				ardto.add(new CustomerDTO(cusid, tmpctel, cname, cpoint, camount, levelname, forLevelUp));
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
		return ardto;
	}

	// -- 7. 전체 출력 : ArrayList<CustomerDTO>getCustomers()
	public ArrayList<CustomerDTO> getCustomers() {
		ArrayList<CustomerDTO> ardto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,"
				+ " (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp"
				+ " FROM CUSTOMER C, CUSLEVEL L" + " WHERE C.LEVELNO = L.LEVELNO ORDER BY CUSAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cusid = rs.getInt("cusid");
				String tmpctel = rs.getString("custel");
				String cname = rs.getString("cusname");
				String levelname = rs.getString("levelname");
				int cpoint = rs.getInt("cuspoint");
				int camount = rs.getInt("cusamount");
				int forLevelUp = rs.getInt("forLevelUp");
				ardto.add(new CustomerDTO(cusid, tmpctel, cname, cpoint, camount, levelname, forLevelUp));
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
		return ardto;
	}

	// -- 8. 회원가입 : int insertCustomer(String cTel,Stirng cName)
	public int insertCustomer(String ctel, String cname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "INSERT INTO CUSTOMER(CUSID, CUSTEL, CUSNAME)" + " VALUES (CUSTOMER_SQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
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

	// -- 9. 번호 수정 : int updateCustomer(int cId, String cTel)
	public int updateCustomer(int cid, String ctel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "UPDATE CUSTOMER SET CUSTEL = ? WHERE CUSID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
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

	// -- 10. 회원 탈퇴 : int deleteCustomer(String cTel)
	public int deleteCustomer(String ctel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "DELETE FROM CUSTOMER WHERE CUSTEL = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
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
}

package member_tbl_02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Member_tbl_02DAO {
	private static Member_tbl_02DAO mdao = new Member_tbl_02DAO();

	public static Member_tbl_02DAO getInstance() {
		return mdao;
	}

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}

//	전체 리스트 가져오기 
	public ArrayList<Member_tbl_02DTO> listMember() {
		ArrayList<Member_tbl_02DTO> mdtoarr = new ArrayList<Member_tbl_02DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_DATE(JOINDATE, 'YY-MM-DD') joindate, GRADE, CITY " + 
				" FROM MEMBER_TBL_02 " + 
				" ORDER BY CUSTNO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				mdtoarr.add(new Member_tbl_02DTO(custno, custname, phone, address, joindate, grade, city));
			}
		} catch (Exception e) {
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
		return mdtoarr;
	}
// 회원 등록 
	public int insertMember(Member_tbl_02DTO mdto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) " + 
				"	VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getCustname());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getAddress());
			pstmt.setDate(4, mdto.getJoindate());
			pstmt.setString(5, mdto.getCustname());
			pstmt.setString(6, mdto.getCustname());
			pstmt.setString(7, mdto.getCustname());
			rs = pstmt.executeQuery();
		} catch (Exception e) {
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
		return result;
	}

	
	
}

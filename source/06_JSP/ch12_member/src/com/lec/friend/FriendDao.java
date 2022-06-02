package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FriendDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static FriendDao INSTANCE;
	
	public static FriendDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new FriendDao();
		}
		return INSTANCE;
	}

	public FriendDao() {
	}
	
	
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	//친구 추가
	public int friendsUpdate(String fname, String ftel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = FAIL;
		String sql = "INSERT INTO FRIEND(FNO, FNAME, FTEL) VALUES(FRIEND_SQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setString(2, ftel);
			result = pstmt.executeUpdate();
			if(result != FAIL) {
				result = SUCCESS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(pstmt != null)pstmt.close();
					if(conn != null)conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}
	
	//친구 검색
	public ArrayList<FriendDto> searchFriends(String fname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE FNAME LIKE ?";
		ArrayList<FriendDto> fdto = new ArrayList<FriendDto>();
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+fname+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
     			do {
	     			int fno = rs.getInt("fno");
					String tmpfname = rs.getString("fname");
					String ftel = rs.getString("ftel");
					fdto.add(new FriendDto(fno, tmpfname, ftel));
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return fdto;
	}
}



















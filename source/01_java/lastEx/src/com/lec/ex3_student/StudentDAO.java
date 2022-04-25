package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 전공 콤보박스,학번검색, 이름검색, 전공검색, 학생입력, 학생수정, 학생출력, 제적자 출력, 제적처리 
public class StudentDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";


	public static int SUCCESS = 1;
	public static int FAIL = 0;

	private static StudentDAO INSTANCE;
	
	public static StudentDAO getInstance(){
		if(INSTANCE == null) {
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
	
	
	// 이름 검색
	public ArrayList<StudentDTO> selectSname(String sname){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
				" FROM STUDENT S, MAJOR M" + 
				" WHERE S.MNO = M.MNO AND SNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mname = rs.getString("mane");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sname,mname,score));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) rs.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return dtos;
	}
	
	
	
	
	
}

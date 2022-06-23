package com.lec.fileboardDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.fileboardDTO.FileBoardDTO;
import com.lec.memberDTO.MemberDTO;

public class FileBoardDAO {
	public final static int EXIST = 1;
	public final static int NONEXIST = 0;
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;

	private DataSource ds;
	private static FileBoardDAO INSTANCE = new FileBoardDAO();
	public static FileBoardDAO getInstance() {
		return INSTANCE;
	}

	public FileBoardDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	};
	
	//글 목록
	public ArrayList<FileBoardDTO> listFileBoard(int startRow, int endRow){
		ArrayList<FileBoardDTO> fdtos = new ArrayList<FileBoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + 
				" (SELECT ROWNUM RN, A.* FROM " + 
				" (SELECT F.*, MNAME FROM FILEBOARD F, MVC2MEMBER M WHERE F.MID=M.MID" + 
				" ORDER BY FGROUP DESC, FSTEP) A) " + 
				" WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				fdtos.add(new FileBoardDTO(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip));
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
		return fdtos;
	}

	//글 갯수 
	public int cntFileBoard(){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
            result = rs.getInt("cnt");
            //result = rs.getInt(1);
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
		return result;
	}
	
	// 원글 글쓰기 
	public int writeFileBoard(FileBoardDTO fdto){
		int result = SUCCESS;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME," + 
				" FGROUP, FSTEP, FINDENT, FIP) " + 
				" VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?," + 
				" FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fdto.getMid());
			pstmt.setString(2, fdto.getFtitle());
			pstmt.setString(3, fdto.getFcontent());
			pstmt.setString(4, fdto.getFfilename());
			pstmt.setString(5, fdto.getFip());
			
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "원글쓰기성공":"원글쓰기실패");
			
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
		return result;
	}

	// (4) FHit 하나 올리기(1번글 조회수 하나 올리기)
	private void hitUp(int fId) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// (5) bId로 글 dto보기 : 글 상세보기(조회수 up + bid로 dto리턴)
	public FileBoardDTO contentViewFileboard(int fid) {
		hitUp(fid);
		FileBoardDTO fdto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC2MEMBER M WHERE M.MID=F.MID AND FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid   = rs.getString("mid");
				String mname = rs.getString("mname"); // join해서 출력
				String ftitle= rs.getString("ftitle");
				String fcontent= rs.getString("fcontent");
				String ffilename= rs.getString("ffileName");
				Date   frdate   = rs.getDate("frdate");
				int    fhit    = rs.getInt("fhit");
				int    fgroup  = rs.getInt("fgroup");
				int    fstep   = rs.getInt("fstep");
				int    findent = rs.getInt("findent");
				String fip     = rs.getString("fip");
				fdto = new FileBoardDTO(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return fdto;
	}
	
	// (5) bId로 글 dto보기 : 답변글 view + 수정 view (bid로 dto리턴)
	public FileBoardDTO modifyView_replyView(int fid) {
		hitUp(fid);
		FileBoardDTO fdto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M "
				+ "WHERE M.MID=F.MID AND FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid   = rs.getString("mid");
				String mname = rs.getString("mname"); // join해서 출력
				String ftitle= rs.getString("ftitle");
				String fcontent= rs.getString("fcontent");
				String ffilename= rs.getString("ffilename");
				Date   frdate   = rs.getDate("frdate");
				int    fhit    = rs.getInt("fhit");
				int    fgroup  = rs.getInt("fgroup");
				int    fstep   = rs.getInt("fstep");
				int    findent = rs.getInt("findent");
				String fip     = rs.getString("fip");
				fdto = new FileBoardDTO(fid, mid, mname ,ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return fdto;
	}
	
	// (6) 글 수정하기(FId, FTitle, FContent, FILENAME,  FIp, FDATE)
	public int modifyFileBoardDTO(FileBoardDTO fdto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FTITLE = ?," + 
							" FCONTENT = ?," + 
							" fFILENAME = ?," + 
							" FIP =  ?," + 
							" FRDATE = SYSDATE" + 
							" WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fdto.getFtitle());
			pstmt.setString(2, fdto.getFcontent());
			pstmt.setString(3, fdto.getFfilename());
			pstmt.setString(4, fdto.getFip());
			pstmt.setInt(5, fdto.getFid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글수정성공":"글수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// (7) 글 삭제하기(bId로 삭제하기)
	public int deleteFileBoard(int fId) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글삭제성공":"글삭제실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// (8) 답변글 추가전 STEP a 수행
	private void preReplyStepA(int bgroup, int bstep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1 " + 
				"    WHERE FGROUP = ? AND FSTEP> ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// (9) 답변글 쓰기
	public int writeReplyFileBoard(FileBoardDTO fdto) {
		preReplyStepA(fdto.getFgroup(), fdto.getFstep()); // 답변글 저장전 step A 먼저 실행
		// bgroup, bstep, bindent 원글정보
		// bname, btitle, bcontent, bip 답변글 정보
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME," + 
				" FGROUP, FSTEP, FINDENT, FIP) " + 
				" VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fdto.getMid());
			pstmt.setString(2, fdto.getFtitle());
			pstmt.setString(3, fdto.getFcontent());
			pstmt.setString(4, fdto.getFfilename());
			pstmt.setInt(5, fdto.getFgroup());
			pstmt.setInt(6, fdto.getFstep()+1);
			pstmt.setInt(7, fdto.getFindent()+1);
			pstmt.setString(8, fdto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "답변쓰기성공":"답변쓰기실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	
	// (10) 회원탈퇴 하려는 사람이 쓴 글 모두 삭제 후 탈퇴
	public void withdrawalDeleteBoard(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}




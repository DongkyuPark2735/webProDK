package com.lec.dao;

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

import com.lec.dto.BookDTO;

public class BookDAO {
	public static final int FALE = 0;
	public static final int SUCCESS = 1;

	private static BookDAO INSTANCE;

//	private BookDAO() {};//밖에서 못만들게?

	public static BookDAO getInsetance() {
		if (INSTANCE == null) {
			INSTANCE = new BookDAO();
		}
		return INSTANCE;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext(); // context의 lookup쓰기위해 객체생성
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g"); // 데이터 소스에 있는걸 가져오기위해
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 책 등록
	public int insertBook(BookDTO book) {
		int result = FALE;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)"
				+ " VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setInt(2, book.getBprice());
			pstmt.setString(3, book.getBimage1());
			pstmt.setString(4, book.getBimage2());
			pstmt.setString(5, book.getBcontent());
			pstmt.setInt(6, book.getBdiscount());

			result = pstmt.executeUpdate(); // 여기서 예외발생함
			System.out.println("책등록 성공");
			// 책 입력 내용 잘못입력하면 아래에서 예외발생함
		} catch (SQLException e) {
			System.out.println(e.getMessage() + book);
		} finally { // inset문은 반드시 닫아야함? 무한반복문같이 발생
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 책목록(전체list)
	public ArrayList<BookDTO> listBook() {
		ArrayList<BookDTO> books = new ArrayList<BookDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				BookDTO book = new BookDTO();
//				book.setBid(rs.getInt("bid"));
//				book.add(book);
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				books.add(new BookDTO(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + books);
		} finally { // inset문은 반드시 닫아야함? 무한반복문같이 발생
			try {
				if(rs!=null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return books;
	}

	// 책 목록(paging : startRow ~ endRow)
	public ArrayList<BookDTO> listBook(int startRow, int endRow) {
		ArrayList<BookDTO> books = new ArrayList<BookDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				" FROM (SELECT ROWNUM RN, B.*" + 
				" FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) B)" + 
				" WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				books.add(new BookDTO(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + books);
		} finally { // inset문은 반드시 닫아야함? 무한반복문같이 발생
			try {
				if(rs!=null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return books;
	}
	
	// 등록된 책갯수
	public int getBookTotCnt() {
		int bookTotalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		try {          // 데이터가 없어도 0이라는 결과값이 반드시 존재함 1행반드시있음
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			bookTotalCnt = rs.getInt("cnt"); //엘리어싱 된  부분 가져옴 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { // inset문은 반드시 닫아야함? 무한반복문같이 발생
			try {
				if(rs!=null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return bookTotalCnt;
	}
	// 책 상세보기(bId로 dto가져오기)
	public BookDTO getBook(int bid) {
		BookDTO book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		try {          // 데이터가 없어도 0이라는 결과값이 반드시 존재함 1행반드시있음
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				book = new BookDTO(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				if(rs!=null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} 
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



















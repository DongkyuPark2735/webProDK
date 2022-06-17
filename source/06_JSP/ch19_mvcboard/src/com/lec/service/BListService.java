package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;
import com.sun.glass.ui.Application;

public class BListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// list.do 또는 list.do?pageNum 또는 list.do?pageNum=10
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE+1;
		int endRow = startRow + PAGESIZE - 1;
		
		BoardDAO dao = BoardDAO.getInsetance();
		request.setAttribute("list", dao.listBoard(startRow, endRow)); // 글목록
		
		int totalCnt = dao.getBoardTotalCnt(); //등록된 글 갯수
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE); // 페이지수
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt) {
			endPage = pageCnt;
		}
		
		request.setAttribute("statPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("pageNum", currentPage); //integer객체로 들어감? //request객체만 object형?
		request.setAttribute("pageCnt", pageCnt);
		
		
		
		
		
	}

}

package com.lec.ch11.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;

public class BlistService implements Service {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();// model을 맵화 리턴값 String Object
	//어트리뷰트 했던 속성값 
		String pageNum = (String)map.get("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE - 1;
				
		BoardDao bdao = BoardDao.getInstance();
		model.addAttribute("boardList", bdao.boardList(startRow, endRow));
		
		int orderNum = startRow;// 출력될 순차번호(1,2,3 순)
		int totCnt = bdao.getBoardTotCnt(); // 전체 글 갯수
		int inverseNum = totCnt - startRow + 1; //출력될 역순번호(10, 9, 8, 7, 순)
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage - 1)/BLOCKSIZE ) * BLOCKSIZE +1;
		startPage = currentPage - (currentPage-1)%BLOCKSIZE;// 다른 방법
		
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageNum", pageNum);
	}
}




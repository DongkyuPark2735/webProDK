package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;
import com.lec.service.Service;

public class BModifyService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		int bid = Integer.parseInt(reqeust.getParameter("bid"));
		String bname = reqeust.getParameter("bname");
		String btitle = reqeust.getParameter("btitle");
		String bcontent = reqeust.getParameter("bcontent");
		String bip = reqeust.getRemoteAddr();
		
		BoardDAO dao = BoardDAO.getInsetance();
		
		reqeust.setAttribute("modifyResult", dao.modify(bid, bname, btitle, bcontent, bip));
	}

}

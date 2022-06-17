package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;

public class BWriteService implements Service {
	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String bname = reqeust.getParameter("bname");
		String btitle= reqeust.getParameter("btitle");
		String bcontent = reqeust.getParameter("bcontent");
		String bip = reqeust.getRemoteAddr();
		
		BoardDAO dao = BoardDAO.getInsetance();
		reqeust.setAttribute("writeResult", dao.write(bname, btitle, bcontent, bip));
		
		
	}

}

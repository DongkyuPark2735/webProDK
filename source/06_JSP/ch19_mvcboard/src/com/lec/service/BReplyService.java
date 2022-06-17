package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;

public class BReplyService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String bname = reqeust.getParameter("bname");
		String btitle = reqeust.getParameter("btitle");
		String bcontent = reqeust.getParameter("bcontent");
		String bip = reqeust.getRemoteAddr();
		
		int bgroup = Integer.parseInt(reqeust.getParameter("bgroup"));
		int bstep = Integer.parseInt(reqeust.getParameter("bstep"));
		int bindent = Integer.parseInt(reqeust.getParameter("bindent"));
		
		BoardDAO dao = BoardDAO.getInsetance();
		
		reqeust.setAttribute("replyResult", dao.reply(bname, btitle, bcontent, bip, bgroup, bstep, bindent));
		
		
		
	}

}

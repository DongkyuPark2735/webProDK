package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;
import com.lec.service.Service;

public class BModifyViewService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		int bid = Integer.parseInt(reqeust.getParameter("bid"));	
		
		BoardDAO dao = BoardDAO.getInsetance();
		
		reqeust.setAttribute("modify_view", dao.modifyView_replyView(bid));
	}
}

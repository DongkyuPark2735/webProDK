package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDAO;

public class BDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		int bid = Integer.parseInt(reqeust.getParameter("bid"));
		
		BoardDAO dao = BoardDAO.getInsetance();
		
		reqeust.setAttribute("deleteResult", dao.delete(bid));
	}

}

package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSevice implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		int result = dao.delete(request.getParameter(name));
		int result = 1;
		request.setAttribute("deleteResult", result);
		
	}

}

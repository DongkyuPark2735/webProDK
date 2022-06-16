package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// insert로직 (dao 생성 = request.getp 파라미터 받아 dto 객체 생성  dao.insert호출)
		int result = 1;
		request.setAttribute("insertResult", result);
		
	}

}

package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	void excute(HttpServletRequest reqeust, HttpServletResponse response);
}

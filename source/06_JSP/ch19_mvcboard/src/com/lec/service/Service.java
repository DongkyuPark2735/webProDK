package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public void excute(HttpServletRequest reqeust, HttpServletResponse response);
}

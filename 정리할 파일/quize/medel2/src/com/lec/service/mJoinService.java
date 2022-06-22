package com.lec.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class mJoinService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024; // 사진 업로드 제한 용향 1m
		try {
			MultipartRequest mrequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String mid = mrequest.getParameter("mid");
			request.setAttribute("mid", mid);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

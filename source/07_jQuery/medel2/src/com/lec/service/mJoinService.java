package com.lec.service;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class mJoinService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024; 
		String mphoto = "";
		try {
			MultipartRequest mrequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mrequest.getFileNames();
			String param = params.nextElement();
			mphoto = mrequest.getFilesystemName(param);
			
			String mid = mrequest.getParameter("mid");
			String mpw = mrequest.getParameter("mpw");
			String mname = mrequest.getParameter("mname");
			String memail = mrequest.getParameter("memail");

			mphoto = mphoto == null ? "NOIMG.JPG" : mphoto;
			
			String mbirthStr = mrequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
			   mbirth = Date.valueOf(mbirthStr);
			}
			
			
			
			request.setAttribute("mid", mid);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}










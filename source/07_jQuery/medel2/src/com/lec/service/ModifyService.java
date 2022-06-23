package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberDAO.MemberDAO;
import com.lec.memberDTO.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ModifyService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024;
		String mphoto = "";
		
		try {
			MultipartRequest mrequest = new MultipartRequest(request, path, maxSize, "utf-8",new DefaultFileRenamePolicy());
			Enumeration<String> params = mrequest.getFileNames();
			String param = params.nextElement();
			mphoto = mrequest.getFilesystemName(param);
			String mid = mrequest.getParameter("mid");
			String mpw = mrequest.getParameter("mpw");
			String mname = mrequest.getParameter("mname");
			String memail = mrequest.getParameter("memail");
			String oldmphoto = mrequest.getParameter("oldmphoto");
			
			mphoto = (mphoto == null) ? oldmphoto : mphoto;

			String mbirthStr = mrequest.getParameter("mbirth");
			Date mbirth = null;
			if (!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mrequest.getParameter("maddress");
			MemberDAO mDao = MemberDAO.getInstance();
			MemberDTO member = new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);

			int result = mDao.modifyMember(member);
			System.out.println(member);
			if (result == MemberDAO.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "정보수정이 완료되었습니다");
			} else {
				request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webProDK/source/07_jQuery/medel2/WebContent/memberPhotoUp/" + mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
				}
			}
		}

	}
}

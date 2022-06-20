package com.lec.memberService;

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

import com.lec.memberDao.MemberDAO;
import com.lec.memberDto.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String path = reqeust.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024;
		String mphoto = "";

		try {
			MultipartRequest mrequest = new MultipartRequest(reqeust, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> params = mrequest.getFileNames();
//				   while(params.hasMoreElements()) { //파일 여러개일떄
			String param = params.nextElement();
			mphoto = mrequest.getFilesystemName(param);
//				   }
			// mrequest를 이용하여 파라미터 받아와서 db저장
			String mid = mrequest.getParameter("mid");
			String mpw = mrequest.getParameter("mpw");
			String mname = mrequest.getParameter("mname");
			String memail = mrequest.getParameter("memail");
			
			String oldmphoto = mrequest.getParameter("oldmphoto");
			//HttpSession session = request.getSession();
			//mPhoto = (mPhoto==null)? ((MemberDto)session.getAttribute("member")).getmPhoto() : mPhoto;
			mphoto = mphoto == null ? oldmphoto : mphoto;
			
			String mbirthStr = mrequest.getParameter("mbirth");
			Date mbirth = null;
			if (!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mrequest.getParameter("maddress");

			MemberDAO mdao = MemberDAO.getInstance();

			MemberDTO member = new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			
			int result = mdao.modifyMember(member);
			if (result == MemberDAO.SUCCESS) {
				HttpSession session = reqeust.getSession();
				session.setAttribute("member", member);
				reqeust.setAttribute("modifyResult", "정보수정이 완료되었습니다");
			} else {
				reqeust.setAttribute("modifyErrorMsg", "정보가 너무 길어서 정보수정 실패.");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		;

		File serverFile = new File(path + "/" + mphoto);

		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;

			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webProDK/source/06_JSP/ch20/WebContent/memberPhotoUp/" + mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}

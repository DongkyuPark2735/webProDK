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

public class MJoinService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		//multipartrequest 처리 여기서? 
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 사진 업로드 제한 용향 1m
		String mphoto = ""; // 첨부파일이 저장된 파일 이름 
		
		// 전역적으로 사용하기에 변수설정 밖에다
		try {
			//mrequest 객체 생성수 mphoto 파일 이름 얻어옴
		   MultipartRequest mrequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		   Enumeration<String> params = mrequest.getFileNames();
//		   while(params.hasMoreElements()) { //파일 여러개일떄
		   String param = params.nextElement();
		   mphoto = mrequest.getFilesystemName(param);
//		   }
		   // mrequest를 이용하여 파라미터 받아와서 db저장
		   String mid = mrequest.getParameter("mid");
		   String mpw = mrequest.getParameter("mpw");
		   String mname = mrequest.getParameter("mname");
		   String memail = mrequest.getParameter("memail");

		   mphoto = mphoto==null ? "NOIMG.JPG" : mphoto;
		   
		   String mbirthStr = mrequest.getParameter("mbirth");
		   Date mbirth = null;
		   if(!mbirthStr.equals("")) {
			   mbirth = Date.valueOf(mbirthStr);
		   }
		   String maddress = mrequest.getParameter("maddress");
		   
		   MemberDAO mdao = MemberDAO.getInstance();
		   
		   //mid중복체크
		   int result = mdao.loginCheck(mid);
		   if(result == MemberDAO.FAIL) {
			   request.setAttribute("joinErrorMsg", "중복된 id는 회원가입이 불가합니다.");
		   }else {
			   MemberDTO member = new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			   result = mdao.joinMember(member);
			   if(result == MemberDAO.SUCCESS) {
				  //session 변수 바로 못씀 jsp의 내장객체
				  HttpSession session = request.getSession(); // 세션은 reqeust로 가져온다
				  session.setAttribute("mid", mid);
				  request.setAttribute("joinResult", "회원가입이 완료되었습니다");
			   }else {
				   request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패.");
			   }
		   }
		} catch (IOException e) {
			System.out.println(e.getMessage());
		};
		
		// 서버에 업로드 된 파일을 소스폴더로 파일 복사   // 사용자에게 배포할떄는 없어도 되는 로직? 
		
		File serverFile = new File(path+"/"+mphoto);
		
			// 빼도됨? 파일 반드시존재?
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webProDK/source/06_JSP/ch20/WebContent/memberPhotoUp/"+mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1) break;
					os.write(bs,0,readByteCnt);
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}












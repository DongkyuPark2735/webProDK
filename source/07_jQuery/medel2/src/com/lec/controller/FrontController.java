package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.AdminLoginService;
import com.lec.service.EmailChkService;
import com.lec.service.FileBoardListService;
import com.lec.service.IdConfirmService;
import com.lec.service.LoginService;
import com.lec.service.LogoutService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.ModifyService;
import com.lec.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commend = uri.substring(conPath.length());
		String viewPath = null;
		Service service = null;
		
		if(commend.equals("/main.do")) { // 메인 뷰 호출
			viewPath = "main/main.jsp";
		}else if(commend.equals("/idConfirm.do")) { //id 확인 
			service = new IdConfirmService();
			service.excute(request, response); 
			viewPath = "member/idConfirm.jsp";
		}else if(commend.equals("/emailChk.do")) { // 이메일 확인
			service = new EmailChkService();
			service.excute(request, response); 
			viewPath = "member/emailChk.jsp";
		}else if(commend.equals("/joinView.do")) { // 회원가입 뷰
			viewPath = "member/join.jsp";	
			
		}else if(commend.equals("/join.do")) { // 회원가입  처리 == 오류
			service = new MJoinService();
			service.excute(request, response); 
			viewPath = "member/loginView.do";	
		}else if(commend.equals("/loginView.do")) { // 로그인 뷰 
			viewPath = "member/loginView.jsp";	
		}else if(commend.equals("/login.do")) { // 로그인 처리
			service = new LoginService();
			service.excute(request, response); 
			viewPath = "main.do";		
		}else if(commend.equals("/adminloginView.do")) { // 관리자 로그인 뷰
			viewPath = "admin/adminloginView.jsp";		
		}else if(commend.equals("/adminlogin.do")) { // 관리자 로그인 처리 
			service = new AdminLoginService();
			service.excute(request, response); 
			viewPath = "main.do";		
		}else if(commend.equals("/logout.do")) { // 로그아웃 처리
			service = new LogoutService();
			service.excute(request, response); 
			viewPath = "main.do";		
		}else if(commend.equals("/modifyView.do")) { // 정보수정 뷰
			viewPath = "member/modifyView.jsp";		
		}else if(commend.equals("/modify.do")) { // 정보수정 처리  === 오류
			service = new ModifyService();
			service.excute(request, response); 
			viewPath = "main.do";		
		}else if(commend.equals("/allView.do")) { // 모든 고객정보
			service = new MAllViewService();
			service.excute(request, response); 
			viewPath = "member/allView.jsp";		
		}else if(commend.equals("/list.do")) { // 글 리스트
			service = new FileBoardListService();
			service.excute(request, response); 
			viewPath = "member/fileBoardList.jsp";		
		}		
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}


















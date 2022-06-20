package com.lec.memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberService.MJoinService;
import com.lec.memberService.MListService;
import com.lec.memberService.MLoginService;
import com.lec.memberService.MLogoutService;
import com.lec.memberService.MModifyService;
import com.lec.memberService.MdeleteService;
import com.lec.memberService.MdetailService;
import com.lec.memberService.Service;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	// 내부에서만 실행 private
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length()); // 주소 추출
		String viewPage = ""; 
		Service service = null;
		
		if(command.equals("/joinView.do")) {//회원가입 화면
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {//회원가입
			service = new MJoinService();
			service.excute(request, response);
			viewPage = "loginView.do";
		}else if(command.equals("/loginView.do")) { //로그인 화면 
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) { //로그인 확인
			service = new MLoginService();
			service.excute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/mAllView.do")) {
			service = new MListService();
			service.excute(request, response);
			viewPage = "member/list.jsp";
		}else if(command.equals("/logout.do")) { // 로그아웃
			service = new MLogoutService();
			service.excute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/modifyView.do")) { // 정보 수정
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) { // 정보 수정
			service = new MModifyService();
			service.excute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/mdetail.do")) {
			service = new MdetailService();
			service.excute(request, response);
			viewPage = "member/mdetail.jsp";
		}else if(command.equals("/mdeleteView.do")) {
			viewPage = "member/mdeleteView.jsp";
		}else if(command.equals("/mdelete.do")) {
			service = new MdeleteService();
			service.excute(request, response);
			viewPage = "member/main.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
			
		
	}
}













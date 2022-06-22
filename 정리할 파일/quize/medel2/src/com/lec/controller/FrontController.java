package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.IdConfirmService;
import com.lec.service.Service;
import com.lec.service.emailChkService;
import com.lec.service.mJoinService;

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
		
		if(commend.equals("/idConfirm.do")) {
			service = new IdConfirmService();
			service.excute(request, response); 
			viewPath = "member/idConfirm.jsp";
		}else if(commend.equals("/emailChk.do")) {
			service = new emailChkService();
			service.excute(request, response); 
			viewPath = "member/emailChk.jsp";
		}else if(commend.equals("/mjoin.do")) {
			service = new mJoinService();
			service.excute(request, response); 
			viewPath = "member/mlogin.jsp";	
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}
}








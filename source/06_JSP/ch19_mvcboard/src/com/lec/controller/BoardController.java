package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BModifyService;
import com.lec.service.BModifyViewService;
import com.lec.service.BReplyService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;
    
	
    public BoardController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//dispatcher.forward할떄 예외?
		String uri = request.getRequestURI();				// /ch19_ / list.do
		String conPath = request.getContextPath();			// /ch19
		String command = uri.substring(conPath.length());	// /list.do
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) {
			service = new BListService();
			service.excute(request, response);
			viewPage = "board/list.jsp"; //conPath 붙여도됨
		}else if(command.equals("/write_view.do")){ //글쓰기 view
			viewPage = "board/write_view.jsp";
			write_view = true;
		}else if(command.equals("/write.do")) { //원글 db저장
			if(write_view) {
				service = new BWriteService();
				service.excute(request, response);
				write_view = false;
			}
			viewPage = "list.do"; 
		}else if(command.equals("/content_view.do")) {
			service = new BContentService();
			service.excute(request, response);
			viewPage = "board/content_view.jsp"; 
		}else if(command.equals("/modify_view.do")) {
			service = new BModifyViewService();
			service.excute(request, response);
			viewPage = "board/modify_view.jsp"; 
		}else if(command.equals("/modify.do")) {
			service = new BModifyService();
			service.excute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {
			service = new BDeleteService();
			service.excute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.excute(request, response);
			viewPage = "board/reply_view.jsp";
		}else if(command.equals("/reply.do")) {
			service = new BReplyService();
			service.excute(request, response);
			viewPage = "list.do";
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);// 위치이동 어디서???
	}
}
























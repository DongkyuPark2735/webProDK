package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteSevice;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;
import com.mysql.cj.jdbc.SuspendableXAConnection;

@WebServlet("*.do") // /빼야함
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI(); // http제외
		String conPath = request.getContextPath(); // /ch18
		String command = uri.substring(conPath.length());// /select.do

		System.out.println("uri =" + uri);
		System.out.println("conPath = " + conPath);
		System.out.println("들어온 요청 = " + command);

		String viewPage = null; // 뷰단의 이름

		Service service = null;
		
		if (command.equals("/insert.do")) { //nullpointExection
			// insert 로직 수행할 객체 생성
			service = new InsertService();
			service.execute(request, response);
			// 객체 이름. 메소드(request, response)
			//request.setAttribute("result", "insert결과");
//			viewPage = "ex2/insert.jsp";// list결과를 못뿌림?
			viewPage = "select.do";// list결과를 못뿌림?
		} else if (command.equals("/select.do")) {
			service = new SelectService();
			service.execute(request, response);
			viewPage = "ex2/select.jsp";
		} else if (command.equals("/delete.do")) {		
			service = new DeleteSevice();
			service.execute(request, response);
			viewPage = "select.do";
		} else if (command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			viewPage = "select.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}

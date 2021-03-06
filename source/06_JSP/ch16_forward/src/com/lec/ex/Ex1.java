package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//넘어온 파라미터 id, pw를 이용해 객처럴 만든후 view단으로 넘긴다
		String id = request. getParameter("id");
		String pw = request. getParameter("pw");
		
		Member member = new Member(id, pw);
		
		request.setAttribute("member", member);
		
		// view단으로 포워드
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_View.jsp");
		dispatcher.forward(request, response);
		
		//response.sendRedirect("1_dispatcher/ex2_View.jsp"); //객체 새롭게
		
		
	}
}

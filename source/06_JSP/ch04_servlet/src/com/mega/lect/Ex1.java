package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8");//response 출력의 한글처리
		// response.setContentType("text/html") 타입이 이상할때 파일다운로드됨? 
		PrintWriter out = response.getWriter();
		out.println("<h2>아이디 : " + id+ "</h2>");
		out.println("<h2>비밀번호 : " + pw + "</h2>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
		
	
	}
}

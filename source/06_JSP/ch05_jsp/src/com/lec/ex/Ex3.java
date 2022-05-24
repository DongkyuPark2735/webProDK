package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청이 들어왔는지?/Ex3/ insert.do / delete.do / update.do
		String conPath = request.getContextPath(); // conPath = "/ch05_jsp"
		String uri = request.getRequestURI(); // uri = "/ch05_jsp/Ex3"
		String command = uri.substring(conPath.length()); // 들어온 요청이 어떤건지 알아볼떄 compath이후에 들어온 문자 받음
		System.out.println("conPath = " + conPath);
		System.out.println("uri = " + uri);
		System.out.println("command = " + command);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

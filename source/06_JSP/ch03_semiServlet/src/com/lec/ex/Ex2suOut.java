package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2suOut
 */
@WebServlet(description = "sumOut", urlPatterns = { "/Ex2suOut" }, name="Ex2suOut" )
public class Ex2suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String numStr = request.getParameter("num");
		if(numStr == null || numStr.equals("")) {
			numStr = "1";
		}
	
		int num = Integer.parseInt(numStr); // 파라미터 모두 스트링으로 들어온다 .
	
		int sum = 0;
		
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
//		response.setCharacterEncoding("text/html; charset=utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>1부터" + num+"까지 누적합은" + sum+"입니다</h1>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

















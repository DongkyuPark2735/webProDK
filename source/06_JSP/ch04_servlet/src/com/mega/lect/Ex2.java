package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu, rest 파라미터 : null, 같은이름의 파라미터가 여러개  : request.getParameterValues("파라미터이름") => 배열로받음
		// nation 파라미터 
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(menu != null) {
			out.println("<p>선택한 메뉴는</p>");
			for(String m : menu) {
				out.println(m+" ");
			}
		}else {
			out.println("<h4>선택한 메뉴가 없습니다.</h4>");
		}
		
		if(rest != null) {
			out.println("<h4>선택한 식당은 "+Arrays.toString(rest)+"입니다.</h4>");
			
		}else {
			out.println("<h4>선택한 식당이 없습니다.</h4>");
		}
		
		out.println("<h4>선택한 국적은 "+nation+"입니다.</h4>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("urf-8");
		doGet(request, response);
	}
	

}

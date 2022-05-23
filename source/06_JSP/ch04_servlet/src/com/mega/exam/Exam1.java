package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(su!=null) {
			for(int i= 0; i <= su.length; i++) {
				int tmpsu = Integer.parseInt(su[i]);
				out.println("<h3>"+su[i]+"단</h3>");
				for(int j = 1; j<=9; j++) {
					out.println("<p>"+tmpsu +" * "+ j + " = " +tmpsu*j+"</p>");
				}
			}			
		}else {
			out.println("<h3>선택된 구구단이 없습니다.</h3>");
		}

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

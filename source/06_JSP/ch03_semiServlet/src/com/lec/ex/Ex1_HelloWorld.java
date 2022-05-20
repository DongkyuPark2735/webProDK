package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1_HelloWorld
 */
// url맵핑 만드시 브라우져에서 볼수 없는 상태로 만들기 위해 맵핑을 통해 접속하게끔  
//@WebServlet("/hw")하나만 들어가 있으몀?? 서블릿이름이랑  맵핑명 같음  web.s에서도 가능

@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" }) 
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//프로젝트의 어느 파일을  실행하더라고 web.xml을 먼저 실행함
	
	//객체정보를 request에  파라미터가 다 담긴다 
	//response에는 HTML 담김? 보낼것이 담김?

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// get방식으로 요청되면 실행되는 함수?
	// TODO Auto-generated method stub			//한글은깨짐 
//		response.getWriter().append("<h1>Served at: 한글 </h1>").append(request.getContextPath());
		System.out.println("doGet호출");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림 객체 생성
		out.print("<html>");
		out.print("<head>");
		
		out.print("<style>");
		out.print("h1{color : blue;}");
		out.print("</style>");
		out.print("</head>");

		out.print("<body>");
		out.print("<h1>안녕하세요, 첫 servlet 예제입니다.<h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 호출할때 실행 
		// TODO Auto-generated method stub
		System.out.println("doPost호출");
		doGet(request, response);
	}
}

























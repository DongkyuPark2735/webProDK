package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/empList")
public class EmpList extends HttpServlet {
    public EmpList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> emps = dao.listEmp();
		request.setAttribute("emps", emps); //jsp파일이름?
		//jsp에서 ${customer} // 세션의 Attribute값 다르게
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empList.jsp");
		dispatcher.forward(request, response);
		
		
			
	}
		
}























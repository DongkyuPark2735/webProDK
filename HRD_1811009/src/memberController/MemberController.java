package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberService.InsertMember;
import memberService.Service;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	actionDo(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = url.substring(conPath.length()); 
		String viewPage = null;
		Service service = null;
		
		if(com.equals("/insertMemberView.do")) {
			viewPage = "member/insertMemberView.jsp";
		}else if(com.equals("/insertMember.do")) {
			service = new InsertMember();
			service.excute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/insetMember.do")){

		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}

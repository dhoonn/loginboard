package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.MemberDTO;
import Service.MemberViewService;

@WebServlet("/memberview")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberViewController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberViewService mViewService = new MemberViewService();
    	MemberDTO memberView = new MemberDTO();
    	memberView = mViewService.memberView(request, response);
    	request.setAttribute("memberView", memberView);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardMyPage.jsp");
    	dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

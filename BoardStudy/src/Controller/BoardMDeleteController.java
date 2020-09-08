package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import DTO.MemberDTO;
import Service.BoardMUpdateService;

@WebServlet("/memberdelete")
public class BoardMDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardMDeleteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardMUpdateService bmUpdateService = new BoardMUpdateService();
    	MemberDTO memberUpdate = bmUpdateService.memberUpdate(request, response);
    	request.setAttribute("boardMDelete", memberUpdate);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardMDelete.jsp");
    	dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

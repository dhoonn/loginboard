package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardMDeleteProcessService;
import Service.BoardMUpdateProcessService;

@WebServlet("/memberdeleteprocess")
public class BoardMDeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardMDeleteProcessController() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardMDeleteProcessService bmdeleteService = new BoardMDeleteProcessService();
    	int boardMDeleteProcess = bmdeleteService.boardMDeleteProcess(request, response);
    	if(boardMDeleteProcess>0) {
    		response.sendRedirect("BoardMDeleteSuccess.jsp");
    	}else {
			response.sendRedirect("BoardMDeleteFail.jsp");
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

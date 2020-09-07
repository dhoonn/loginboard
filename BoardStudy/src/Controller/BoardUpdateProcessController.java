package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardUpdateProcessService;

@WebServlet("/boardupdateprocess")
public class BoardUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardUpdateProcessService bupdateService = new BoardUpdateProcessService();
    	int boardUpdateProcess = bupdateService.boardUpdateProcess(request, response);
    	if(boardUpdateProcess>0) {
    		response.sendRedirect("BoardUpdateSuccess.jsp");
    	}else {
			response.sendRedirect("BoardUpdateFail.jsp");
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import Service.BoardUpdateService;

@WebServlet("/boardupdate")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardUpdateService bUpdateService = new BoardUpdateService();
    	BoardDTO boardUpdate = bUpdateService.boardUpdate(request, response);
    	request.setAttribute("boardUpdate", boardUpdate);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardUpdate.jsp");
    	dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

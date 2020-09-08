package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import Service.BoardSortService;

@WebServlet("/boardsort")
public class BoardSortController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSortController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardSortService bSortService = new BoardSortService();
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList = bSortService.boardSort();
		if (boardList != null) {
			request.setAttribute("boardList", boardList); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardMain.jsp"); 
			dispatcher.forward(request,response);
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

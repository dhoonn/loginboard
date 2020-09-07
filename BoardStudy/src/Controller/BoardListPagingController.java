package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import DTO.PageDTO;
import Service.BoardListPagingService;

@WebServlet("/boardlistpaging")
public class BoardListPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListPagingController() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardListPagingService bListPagingService = new BoardListPagingService();
    	
    	//클릭한 페이지에 필요한 글만 가져오기 위한 메소드 호출                                                                              
    	List<BoardDTO> boardList = bListPagingService.boardList(request, response);
    	
    	// 페이지 번호와 관련된 정보 등을 결정하기 위한 메소드 호출
    	PageDTO paging = bListPagingService.paging(request, response);
    	
    	request.setAttribute("boardList", boardList);  //?
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardMain.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}

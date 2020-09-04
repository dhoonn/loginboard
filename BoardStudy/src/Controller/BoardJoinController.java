package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardJoinService;

@WebServlet("/boardjoin")
public class BoardJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardJoinController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardJoinService bjoinService = new BoardJoinService();
    	int joinResult = bjoinService.boardJoin(request, response);
    	if(joinResult>0) {
			response.sendRedirect("BoardFirstMain.jsp");
		}else {
			response.sendRedirect("BoardJoinFail.jsp");
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}



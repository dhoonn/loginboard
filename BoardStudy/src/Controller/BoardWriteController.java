package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardWriteService;

@WebServlet("/boardwrite")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardWriteService bWriteService = new BoardWriteService();
    	int writeResult = bWriteService.boardwrite(request, response);
    	if(writeResult>0) {
    		response.sendRedirect("BoardWriteSuccess.jsp");
    	}else {
    		response.sendRedirect("BoardWriteFail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

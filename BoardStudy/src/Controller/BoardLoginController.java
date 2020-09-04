package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BoardLoginService;

@WebServlet("/boardlogin")
public class BoardLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardLoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardLoginService bloginService = new BoardLoginService();
    	String loginId = bloginService.boardLogin(request, response);

    	HttpSession session = request.getSession();
    	if(loginId != null) {
    		session.setAttribute("loginId", loginId);
    		request.setAttribute("loginIdreq", loginId);
    		response.sendRedirect("BoardMain.jsp");
    	}else {
    		response.sendRedirect("BoardLoginFail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

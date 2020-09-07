package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;

public class BoardDeleteService {

	public int boardDelete(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int deleteResult = bDAO.boardDelete(bnumber);
		bDAO.dbClose();
		return deleteResult;
	}

}

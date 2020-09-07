package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardUpdateService {

	public BoardDTO boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		BoardDTO boardUpdate = bDAO.boardUpdate(bnumber);
		bDAO.dbClose();
		return boardUpdate;
	}

}

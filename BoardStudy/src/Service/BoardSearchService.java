package Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardSearchService {

	public List<BoardDTO> boardSearch(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		List<BoardDTO> searchList = bDAO.boardSearch(keyword);
		bDAO.dbClose();
		return searchList;
	}

}

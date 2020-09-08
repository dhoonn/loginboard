package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardSortService {

	public List<BoardDTO> boardSort() {
		BoardDAO bDAO = new BoardDAO();
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		bDAO.dbConnection();
		boardList = bDAO.boardSort();
		bDAO.dbClose();
		return boardList;
	}

}

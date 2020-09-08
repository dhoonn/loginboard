package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardWriteService {

	public int boardwrite(HttpServletRequest request, HttpServletResponse response) {
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		String bfilename = request.getParameter("bfilename");
//		String bpassword = request.getParameter("bpassword");
		
		BoardDTO board = new BoardDTO();
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcontents(bcontents);
		board.setBfilename(bfilename);
//		board.setBpassword(bpassword);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int writeResult = bDAO.boardWrite(board);
		bDAO.dbClose();
		
		
		return writeResult; 
	}

}

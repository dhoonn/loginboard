package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardUpdateProcessService {

	public int boardUpdateProcess(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		
		BoardDTO boardUpdateProcess = new BoardDTO();
		boardUpdateProcess.setBnumber(bnumber);
		boardUpdateProcess.setBwriter(bwriter);
		boardUpdateProcess.setBtitle(btitle);
		boardUpdateProcess.setBcontents(bcontents);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int processResult = bDAO.boardUpdateProcess(boardUpdateProcess);
		bDAO.dbClose();
		return processResult;
	
	}

}

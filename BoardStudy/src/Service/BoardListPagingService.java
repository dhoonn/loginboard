package Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;
import DTO.PageDTO;

public class BoardListPagingService {

private static final int PAGE_LIMIT = 5;
	
	//BLOCK_LIMIT " 한 화면상에 노출되는 페이지 갯수
	//예를 들어 1~5까지 보이고 그다음은 6~10, 11~15....
	private static final int BLOCK_LIMIT = 5;

	public List<BoardDTO> boardList(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		
		/*
		 * 1페이지에는 가장 최신글 순으로 글 3개 까지 나오고
		 * 2페이지는 그다음 3개글
		 * 3페이지는 그다음 3개글
		 * 
		 * page가 1이면 startRow = 1-1*3+1=1
		 * 				endRow = 1*3=3
		 * 
		 * page가 2이면 startRow = 2-1*3+1=4
		 *	 			endRow = 2*3=6
		 * 
		 * page가 3이면 startRow = 3-1*3+1=7
		 *				endRow = 3*3=9
		 */
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		List<BoardDTO> boardList = bDAO.boardListPaging(startRow, endRow);
		bDAO.dbClose();
		
		//현재 페이지에서 필요한 글만 db에서 가지고 와서 컨트롤러에 넘겨줌
		return boardList;
	}

	public PageDTO paging(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		
		//최대 필요한 페이지 갯수
		//한페이지에 보여줄 글 갯수3개
		//전체 글 갯수8개
		//필요한 최대 페이지 갯수는?8/3=2.666 => 3(ceil)
		
		//DB에 저장된 전체 글 갯수 가져옴
		int listCount = bDAO.listCount();
		bDAO.dbClose();
		
		//최대 필요한 페이지 갯수
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT));
		
		//시작 페이지(1,6,11,16,21,~~~)
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		
		//마지막 페이지(5,10,15,20,25,~~~~)
		int endPage = startPage + BLOCK_LIMIT - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		return paging;
	}
}

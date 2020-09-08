package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;

public class BoardMDeleteProcessService {

	public int boardMDeleteProcess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("loginId");
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int deleteResult = mDAO.memberDelete(mid);
		mDAO.dbClose();
		return deleteResult;
	}

}

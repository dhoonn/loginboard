package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class BoardMUpdateService {

	public MemberDTO memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		MemberDTO memberUpdate = mDAO.memberUpdate(mid);
		mDAO.dbClose();
		return memberUpdate;
	}

}

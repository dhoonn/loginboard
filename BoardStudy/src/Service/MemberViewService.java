package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class MemberViewService {

	public MemberDTO memberView(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		MemberDTO memberView = mDAO.memberView(mid);
		mDAO.dbClose();
		return memberView;
	}

}

package Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class BoardMUpdateProcessService {

	public int boardMUpdateProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "C:\\Users\\이동훈\\git\\loginboard\\BoardStudy\\WebContent\\UploadFile";

		MultipartRequest multi = new MultipartRequest(request, savePath, 10 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		String mid = multi.getParameter("mid");
		String mpassword = multi.getParameter("mpassword");
		String mname = multi.getParameter("mname");
		String mbirth = multi.getParameter("mbirth");
		String memail = multi.getParameter("memail");
		String maddress = multi.getParameter("maddress");
		String mphone = multi.getParameter("mphone");
		String mprofile = multi.getOriginalFileName((String) multi.getFileNames().nextElement());
		
		MemberDTO memberUpdateProcess = new MemberDTO();
		memberUpdateProcess.setMid(mid);
		memberUpdateProcess.setMpassword(mpassword);
		memberUpdateProcess.setMname(mname);
		memberUpdateProcess.setMbirth(mbirth);
		memberUpdateProcess.setMemail(memail);
		memberUpdateProcess.setMaddress(maddress);
		memberUpdateProcess.setMphone(mphone);
		memberUpdateProcess.setMprofile(mprofile);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int processResult = mDAO.boardMUpdateProcess(memberUpdateProcess);
		mDAO.dbClose();
		return processResult;
	}

}

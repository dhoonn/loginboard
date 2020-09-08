package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConnection;
import DTO.BoardDTO;
import DTO.MemberDTO;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void dbConnection() {
		con = DBConnection.getConnection();
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int boardJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER1(MID,MPASSWORD,MNAME,MBIRTH,MEMAIL,MADDRESS,MPHONE,MPROFILE)"
				+"VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpassword());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMemail());
			pstmt.setString(6, member.getMaddress());
			pstmt.setString(7, member.getMphone());
			pstmt.setString(8, member.getMprofile());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return joinResult;
	}

	public boolean boardLogin(String mid, String mpassword) {
		String sql = "SELECT * FROM MEMBER1 WHERE MID=? AND MPASSWORD=?";
		boolean loginresult = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpassword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginresult = true;
			}else {
				loginresult = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return loginresult;
	}

	public MemberDTO memberUpdate(String mid) {
		String sql = "SELECT * FROM MEMBER1 WHERE MID=?";
		MemberDTO memberUpdate = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberUpdate = new MemberDTO();
				memberUpdate.setMid(rs.getString("MID"));
				memberUpdate.setMpassword(rs.getString("MPASSWORD"));
				memberUpdate.setMname(rs.getString("MNAME"));
				memberUpdate.setMbirth(rs.getString("MBIRTH"));
				memberUpdate.setMemail(rs.getString("MEMAIL"));
				memberUpdate.setMaddress(rs.getString("MADDRESS"));
				memberUpdate.setMphone(rs.getString("MPHONE"));
				memberUpdate.setMprofile(rs.getString("MPROFILE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return memberUpdate;
	}

	public int boardMUpdateProcess(MemberDTO memberUpdateProcess) {
		String sql = "UPDATE MEMBER1 SET MNAME=?, MBIRTH=?, MEMAIL=?, MADDRESS=?, MPHONE=?, MPROFILE=? WHERE MID=?";
		int processResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberUpdateProcess.getMname());
			pstmt.setString(2, memberUpdateProcess.getMbirth());
			pstmt.setString(3, memberUpdateProcess.getMemail());
			pstmt.setString(4, memberUpdateProcess.getMaddress());
			pstmt.setString(5, memberUpdateProcess.getMphone());
			pstmt.setString(6, memberUpdateProcess.getMprofile());
			pstmt.setString(7, memberUpdateProcess.getMid());
			processResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return processResult;
	}

	public MemberDTO memberView(String mid) {
		String sql = "SELECT * FROM MEMBER1 WHERE MID=?";
		MemberDTO memberView = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberView = new MemberDTO();
				memberView.setMid(rs.getString("MID"));
				memberView.setMpassword(rs.getString("MPASSWORD"));
				memberView.setMname(rs.getString("MNAME"));
				memberView.setMbirth(rs.getString("MBIRTH"));
				memberView.setMemail(rs.getString("MEMAIL"));
				memberView.setMaddress(rs.getString("MADDRESS"));
				memberView.setMphone(rs.getString("MPHONE"));
				memberView.setMprofile(rs.getString("MPROFILE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return memberView;
	}

	public int memberDelete(String mid) {
		String sql = "DELETE FROM MEMBER1 WHERE MID=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return deleteResult;
	}
	

}

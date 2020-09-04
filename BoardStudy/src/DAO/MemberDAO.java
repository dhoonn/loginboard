package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConnection;
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
	

}

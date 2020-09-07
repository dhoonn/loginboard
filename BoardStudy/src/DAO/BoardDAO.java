package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;
import DTO.BoardDTO;

public class BoardDAO {
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

	public int boardWrite(BoardDTO board) {
		String sql = "INSERT INTO BOARD1(BNUMBER,BWRITER,BTITLE,BCONTENTS,BDATE,BHITS,BFILENAME)"
				+"VALUES(SEQ_BOARD.NEXTVAL,?,?,?,SYSDATE,0,?)";
	int writeResult = 0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, board.getBwriter());
		pstmt.setString(2, board.getBtitle());
		pstmt.setString(3, board.getBcontents());
		pstmt.setString(4, board.getBfilename());
//		pstmt.setString(5, board.getBpassword());
		writeResult = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		pstmtClose();
	}
	return writeResult;

	}

	public void boardHits(int bnumber) {
		String sql = "UPDATE BOARD1 SET BHITS=BHITS+1 WHERE BNUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public BoardDTO boardView(int bnumber) {
		String sql = "SELECT * FROM BOARD1 WHERE BNUMBER=?";
		BoardDTO boardView = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs = pstmt.executeQuery();
			if(rs.next()){
				boardView = new BoardDTO();
				boardView.setBnumber(rs.getInt("BNUMBER"));
				boardView.setBwriter(rs.getString("BWRITER"));
				boardView.setBtitle(rs.getString("BTITLE"));
				boardView.setBcontents(rs.getString("BCONTENTS"));
				boardView.setBdate(rs.getDate("BDATE"));
				boardView.setBhits(rs.getInt("BHITS"));
				boardView.setBfilename(rs.getString("BFILENAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardView;
	}

	public List<BoardDTO> boardListPaging(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}

	public int listCount() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public BoardDTO boardUpdate(int bnumber) {
		String sql = "SELECT * FROM BOARD1 WHERE BNUMBER=?";
		BoardDTO boardUpdate = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				boardUpdate = new BoardDTO();
				boardUpdate.setBnumber(rs.getInt("BNUMBER"));
				boardUpdate.setBwriter(rs.getString("BWRITER"));
				boardUpdate.setBtitle(rs.getString("BTITLE"));
				boardUpdate.setBcontents(rs.getString("BCONTENTS"));
				boardUpdate.setBdate(rs.getDate("BDATE"));
				boardUpdate.setBhits(rs.getInt("BHITS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return boardUpdate;
	}

	public int boardUpdateProcess(BoardDTO boardUpdateProcess) {
		String sql = "UPDATE BOARD1 SET BWRITER=?, BTITLE=?, BCONTENTS=? WHERE BNUMBER=?";
		int processResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardUpdateProcess.getBwriter());
			pstmt.setString(2, boardUpdateProcess.getBtitle());
			pstmt.setString(3, boardUpdateProcess.getBcontents());
			pstmt.setInt(4, boardUpdateProcess.getBnumber());
			processResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return processResult;
	}

	public int boardDelete(int bnumber) {
		String sql = "DELETE FROM BOARD1 WHERE BNUMBER=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return deleteResult;
	}
}

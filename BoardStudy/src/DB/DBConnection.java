package DB;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
			con = ds.getConnection();
			con.setAutoCommit(true);
			System.out.println("DBCP 연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}


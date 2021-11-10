package book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {


		// connection
		public static Connection getConnection() {
			try {
				Context ctx = new InitialContext();
				// java:comp/env : 이름으로 찾을 떄 사용하는 공간의 이름
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
				Connection con =  ds.getConnection();
				// autoCommit을 true 에서 fals
				con.setAutoCommit(false);
				return con;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// commit
		public static void commit(Connection con) {
			try {
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//rollback
		public static void rollback(Connection con) {
			try {
				con.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		// 자원 해제
		public static void close(Connection con) {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		public static void close(PreparedStatement pstmt) {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		public static void close(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	
}

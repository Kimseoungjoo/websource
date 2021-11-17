package board.service;

import java.sql.Connection;

import board.persistence.BoardDAO;

import static board.domain.JdbcUtil.*;

public class BoardRemoveService {
	public boolean remove(int bno, String password) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean deleteFlag = dao.delete(bno, password);
		
		if(deleteFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return deleteFlag;
	}
}

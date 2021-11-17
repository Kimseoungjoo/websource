package board.service;

import java.sql.Connection;

import static board.domain.JdbcUtil.*;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardInsertService {
	public boolean boardInsert(BoardDTO insertDto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean insertFlag = dao.insert(insertDto);
	
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

}

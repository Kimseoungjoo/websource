package board.service;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

import static board.domain.JdbcUtil.*;
public class BoardReplyService {
	public boolean reply(BoardDTO dto) {
		//update하는dao를 먼저 부른다 
		Connection con =getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		dao.replyUpdate(dto);
		commit(con);
		boolean insertFlag = dao.replyInsert(dto);
		
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
	
			
		
		close(con);
		return insertFlag;
	}
}

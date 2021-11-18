package board.service;

import java.sql.Connection;
import java.util.List;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.persistence.BoardDAO;

import static board.domain.JdbcUtil.*;

public class BoardListService {
	public List<BoardDTO> all(PageDTO pageDto){
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list =  dao.getList(pageDto);
		
		
		close(con);
		
		return list;
		
		
	}
}

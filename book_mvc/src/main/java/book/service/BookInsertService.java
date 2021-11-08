package book.service;

import java.sql.Connection;

import book.domain.BookDTO;
import book.persistence.BookDAO;

import static book.persistence.JdbcUtil.*;

public class BookInsertService {
	public boolean bookInsert(BookDTO dto) {
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		boolean insertFlag=dao.insert(dto);
		
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return insertFlag;
	}
}

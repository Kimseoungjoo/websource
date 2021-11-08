package book.service;

import java.sql.Connection;

import book.persistence.BookDAO;

import static book.persistence.JdbcUtil.*;

public class BookModifyService {
	public boolean update(String code, int price) {
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		
		boolean updateFlag =dao.update(code, price) ;
		
		if(updateFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return updateFlag;
	}
}

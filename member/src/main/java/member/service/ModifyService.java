package member.service;

import java.sql.Connection;

import member.domain.UpdateDTO;
import member.persistence.MemberDAO;

import static member.persistence.JdbcUtil.*;

public class ModifyService {
	public boolean modifyService(UpdateDTO updateDto)	{
		Connection con = getConnection();
		
		MemberDAO dao = new MemberDAO(con);
		boolean updateFlag= dao.update(updateDto);
		
		if(updateFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		 
		return updateFlag;
	}
}

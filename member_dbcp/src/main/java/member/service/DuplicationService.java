package member.service;

import static member.persistence.JdbcUtil.*;

import java.sql.Connection;

import member.persistence.MemberDAO;

public class DuplicationService {
	public boolean dupId(String userid) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		boolean  dupFlag = dao.dupId(userid);
		
		close(con);
		
		return dupFlag;
	}
}

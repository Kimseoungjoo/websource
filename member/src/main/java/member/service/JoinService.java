package member.service;

import static member.persistence.JdbcUtil.*;

import java.sql.Connection;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

public class JoinService {
	public boolean register(MemberDTO dto) {
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);

		boolean registerFlag = dao.register(dto);
		
		if(registerFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return registerFlag;
	}
}

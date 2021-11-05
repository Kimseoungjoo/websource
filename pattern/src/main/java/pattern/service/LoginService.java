package pattern.service;

import java.sql.Connection;

import pattern.domain.MemberDTO;
import pattern.persistence.MemberDAO;

import static pattern.persistence.JdbcUtil.*;

public class LoginService {
	
	public MemberDTO loginService(String userid, String password) {
		// db작업 !!은 service패키지에서 = > 비지니스 로직(MVC M)
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO loginDto = dao.login(new MemberDTO(userid, password));
		
		
		return loginDto;
		
	}
}

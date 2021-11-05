package member.service;

import java.sql.Connection;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

import static member.persistence.JdbcUtil.*;

public class LoginService {
	public MemberDTO loginService(String userid, String passwrod)	{
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO loginDto = dao.isLogin(userid, passwrod);
		
		close(con);
		
		return loginDto;
	}
}

package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import oracle.jdbc.proxy.annotation.Pre;

// 클래스 안의 메소드가 static 으로만 구성되어 있다면
// import를 static 으로 하는 것이 가능함 
import static member.persistence.JdbcUtil.*;

public class MemberDAO {
	private Connection con;
	
	public MemberDAO(Connection con) {
		
		this.con = con;
		
	}
	
	// login => select
	public MemberDTO isLogin(String userid, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO loginDto = null;
		
		try {
			
			String sql = "select userid,name from member where userid=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginDto = new MemberDTO();
				
				loginDto.setUserid(rs.getString(1));
				loginDto.setName(rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return loginDto;
	}
	public boolean delete(String userid, String password) {
		boolean deleteFlag =false;
		PreparedStatement pstmt = null;

		try {
			String sql = "delete from member where userid=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) deleteFlag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return deleteFlag;
	}
	
	//비밀번호 변경 하는 메소드 
	
	public boolean update(UpdateDTO updateDto) {
		boolean updateFlag = false;
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "update member set password=?  where userid=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, updateDto.getNewPassword());
			pstmt.setString(2, updateDto.getUserid());
			pstmt.setString(3, updateDto.getCurrentPassword());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) updateFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
		
		return updateFlag;
	}
	
	// 회원가입 메소드
	public boolean register(MemberDTO dto) {
		boolean registerFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into member values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) registerFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return registerFlag;
	}
	// 아이디 중복 검사 
	public boolean dupId(String userid) {
		PreparedStatement pstmt = null;
		boolean dupIdFlag = true;
		ResultSet rs = null;
		
		try {
			String sql = "select * from member where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				dupIdFlag = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dupIdFlag;
		
	}
	
}

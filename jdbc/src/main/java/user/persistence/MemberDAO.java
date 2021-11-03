package user.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import user.domain.MemberDTO;


// 클래스 안의 메소드가 static 으로만 구성되어 있다면
// import를 static 으로 하는 것이 가능함 
import static user.persistence.JdbcUtil.*;

@AllArgsConstructor
public class MemberDAO {
	private Connection con;
	
	//insert
	public boolean insert(MemberDTO dto) {
		boolean insertFlag=false;
		PreparedStatement pstmt = null;
	
		
		try {
			String sql = "insert into member(userid,password,name,gender,email) values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				insertFlag = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// connection 부분은 닫지 않는다.
				// JdbcUtil.close(pstmt);
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return insertFlag;
	}
	//update
	public boolean update(MemberDTO dto) {
		
		PreparedStatement pstmt = null;
		boolean updateFlag = false;
		
		try {
			String sql = "update member set password = ? where userid = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getChangePassword());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPassword());
			
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
	//delete 
	public boolean delete(String userid, String password) {
		boolean deleteFlag = false;
		PreparedStatement pstmt = null;
		
		try {
				String sql = "delete from member where userid = ? and password = ? ";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				int result = pstmt.executeUpdate();
				if(result>0) deleteFlag = true;
			
			
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
	
	
	//select - 개별조회
	public MemberDTO getRow(MemberDTO dto) {
		MemberDTO dto1 = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from member where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto1 = new MemberDTO();
			dto1.setUserid(rs.getString("userid"));
			dto1.setName(rs.getString("name"));
			dto1.setGender(rs.getString("gender"));
			dto1.setEmail(rs.getString("email"));
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
		return dto1;
		
	}
	
	
	
	//select - 전체조회
	public  List<MemberDTO> getRows(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			
			String sql = "select * from member";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));
				
				
				list.add(dto);
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
		return list;
		
	}
	
}

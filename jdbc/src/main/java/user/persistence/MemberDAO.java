package user.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	//delete 
	
	//select 
}

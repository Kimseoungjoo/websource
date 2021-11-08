package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.persistence.JdbcUtil;
import member.service.LeaveService;
import member.service.ModifyService;

@AllArgsConstructor
public class ModifyAction implements Action {
	private String path;
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//userid를 가져오는 방법 (현재 session에 들어있다)
		HttpSession session = request.getSession();
		MemberDTO loginDto = (MemberDTO) session.getAttribute("loginDto");
		String userid = loginDto.getUserid();
		
		// modifyForm.jsp에서 사용자 입력값 가져오기 
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		UpdateDTO updateDto = new UpdateDTO(userid, current_password, new_password, confirm_password);
		
		// 결과에 따라서 페이지 이동 
		if(updateDto.passwordEqualTo(confirm_password)) {

			// db작업 서비스에게 부탁
			ModifyService service = new ModifyService();
			boolean updateFlag = service.modifyService(updateDto);

			//성공 => commit , session 해체 , 로그인 페이지 이동
			if(updateFlag) {
				
				session.invalidate();
				//path = "/view/login.form.jsp";
				
			}else {
				
				//실패 => rollback, 비밀번호 변경페이지
				path = "/view/modify.form.jsp";
				
			}
		
		}else {
			// 비밀번호 변경 페이지로 이동 
			path = "/view/modify.form.jsp";
		}
	
		return  new ActionForward(path,true);
	}

}

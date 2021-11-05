package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.service.LeaveService;

@AllArgsConstructor
public class LeaveAction implements Action {
	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// leaveForm.jsp 에서 사용자 입력 값을 가져와야한다 
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		// db작업 서비스에게 부탁
		LeaveService service = new LeaveService();
		boolean leaveFlag = service.leave(userid, password);
		// 결과에 따라서 페이지 이동 
		if(leaveFlag) {
			// 세션 해제 
			HttpSession session = request.getSession();
			session.removeAttribute("loginDto");
		}else {
			path = "/view/leaveForm.jsp";
		}
		
		return  new ActionForward(path,true);
	}

}

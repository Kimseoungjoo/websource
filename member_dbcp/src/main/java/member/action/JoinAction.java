package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.JoinService;

@AllArgsConstructor
public class JoinAction implements Action {
	private String path;
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//joinForm.jsp에서 넘긴 값 가져오기 
		MemberDTO dto = new MemberDTO();
		
		dto.setUserid(request.getParameter("userid"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		
		// db 작업 요청
		JoinService service = new JoinService();
		boolean joinFlag = service.register(dto);
		
		//결과에 따라 페이지 이동
		if(!joinFlag) {
			path = "/view/joinForm.jsp";
		}
		return new ActionForward(path,true);
	}

}

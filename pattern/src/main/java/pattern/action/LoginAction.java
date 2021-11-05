package pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pattern.domain.MemberDTO;
import pattern.service.LoginService;

@AllArgsConstructor
@Getter
public class LoginAction implements Action {
	private String path; // index.jsp가 담겨져 있다.
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// 사용자가 넘기는 값 가져오기
		String userid = request.getParameter("userid");
		String password= request.getParameter("password");
		
		System.out.println("userid: "+ userid);
		System.out.println("password: "+ password);
		
		// 서비스 작업
		LoginService service = new LoginService();
		MemberDTO loginDto = service.loginService(userid,password);
		
		// 결과에 따라서 ActionForward 객체 생성 (페이지로 이동)
		if(loginDto==null) { // 로그인 실패 
			path = "/view/login.jsp"; // 로그인 폼을 보여주는 작업 
		}else { // 로그인 성공 >> session작업을 해줘야한다. 
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			path = "/index.jsp";//index페이지로 이동
		}
		
		//로그인이 실패가 됐을 떄 new AciontForward("/veiw/login.jsp",true);
		//로그인이 성공했을 떄 new AciontForward("/index.jsp",true);
		
		
		// getParameter 인자를 가져올 수 있다. 
		// 원래는 get 방식이나 form 방식은 다음 페이지까지 request할 수 있으나 지금은 클래스로 받고 있기 때문에 가능하다 .
		return new ActionForward(path,true);  //true >>sendRedirect 방식 주소줄을 보여주도록 하겄다 이말이야
	}

}

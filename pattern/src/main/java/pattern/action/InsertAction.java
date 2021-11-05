package pattern.action;

import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pattern.service.InsertService;

@AllArgsConstructor
@Getter
public class InsertAction implements Action {
	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// 사용자가 넘기는 값 가져오기
		String userid = request.getParameter("userid");
		String password= request.getParameter("password");
		
		System.out.println("userid: "+ userid);
		System.out.println("password: "+ password);
		
		// 서비스 작업
		InsertService service = new InsertService();
		boolean loginFlag = service.loginService(userid,password);
		
		// 결과에 따라서 ActionForward 객체 생성 (페이지로 이동)
		if(loginFlag) { 
			
		}else {
			
		}
		
		// getParameter 인자를 가져올 수 있다. 
		// 원래는 get 방식이나 form 방식은 다음 페이지까지 request할 수 있으나 지금은 클래스로 받고 있기 때문에 가능하다 .
		return new ActionForward(path,false); 
	}

}

package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionForward;
// Servlet File로 만들어서 모든 파일을 MVC:C 를 담당 컨트롤하는 곳~ 

@WebServlet("*.do") // *do : URL은 내맘대로 변경할 수 있다.
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청에 대한 한글 처리
		request.setCharacterEncoding("utf-8");	
		// 어디서 요청이 왔는지 찾기
	    String requestUri = request.getRequestURI();
	    String contextPath = request.getContextPath();
	    String cmd = requestUri.substring(contextPath.length());
	    
	    // 요청에 따라서 해당 Action을 생성하는 작업 
		ActionFactory af = ActionFactory.getInstance(); // 객체 생성을 하나만 하는 방식(singleton Pattern)
		Action action = af.action(cmd);
		
		ActionForward actionForward = null;
		try {
			// 생성된 Action에게 일을 시킴 => 결과를 ActionForward 객체로 넘겨 받음
			actionForward = action.excute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//로그인이 실패가 됐을 떄 new AciontForward("/veiw/login.jsp",true);
				//로그인이 성공했을 떄 new AciontForward("/index.jsp",true);
		
		
		// 념겨받은 ActionForward가 가지고 있는 값에 따라서 페이지 이동
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getPath());
		}else {
			//pageContext.forward()는 사용못한다(Why? jsp에서만 사용가능)
			RequestDispatcher rd = request.getRequestDispatcher(actionForward.getPath());
			rd.forward(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

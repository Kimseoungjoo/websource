package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.BoardAction;
import board.action.BoardActionFactory;
import board.action.BoardActionForward;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 인코딩 설정(post)
		request.setCharacterEncoding("utf-8");
		
		// ex) http://localhost:8080/(insert.do)=>필요부분
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestUri.substring(contextPath.length());
		
		// cmd에 따라 Action을 생성
		BoardActionFactory baf = BoardActionFactory.getInstance();
		BoardAction action = baf.action(cmd);
		
		// 생성된 action에게 일을 시키면 된다.
		BoardActionForward af = null;
		try {
			af = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 리턴받은 af에 따라서 이동
		if(af.isRedirect()) { // true ==> SendRedirect
			response.sendRedirect(af.getPath());
		}else { // false ==> request
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

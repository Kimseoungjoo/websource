package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionForward;


@WebServlet("*.do") // *do :URL은 내맘대로 변경할 수 있다.
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		
		   String requestUri = request.getRequestURI();
			
			ActionFactory af = ActionFactory.getInstance();
			Action action = af.action(requestUri);
			
			ActionForward actionForward = null;
			try {
				actionForward = action.excute(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

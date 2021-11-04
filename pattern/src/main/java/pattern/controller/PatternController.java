package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do") // *do :URL은 내맘대로 변경할 수 있다.
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String requestUri = request.getRequestURI();
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("requestURI " +requestUri);
			
			if(requestUri.equals("/insert.do")) {
			       out.print("insert.jsp가 보낸값");
		      } else if (requestUri.equals("/update.do")) {
		         out.print("update.jsp가 보낸 값");
		      } else if (requestUri.equals("/index.do")) {
		         out.print("index.jsp가 보낸 값");
		         
		      }

		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

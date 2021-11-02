package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/add")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// cart.jsp에서 넘긴 값 가져오기
		String product = request.getParameter("product");
		//session 에 값 담기
		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		// 페이지 이동
		
		// 장바구니 보기 페이지 이동 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

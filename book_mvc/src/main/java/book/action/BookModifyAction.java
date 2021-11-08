package book.action;

import javax.servlet.http.HttpServletRequest;

import book.service.BookModifyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookModifyAction implements BookAction {

	private String path;
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// modify.jsp 에서 값 넘겨받기
		String code = request.getParameter("code");
		int price = Integer.parseInt(request.getParameter("price"));
		
		//modifyService db작업
		BookModifyService service = new BookModifyService();
		boolean updateFlag = service.update(code, price);
		
		//페이지 이동
		if(!updateFlag) {
			path = "/index.jsp?tab=modify";
		}
		
		return new BookActionForward(path,true);
	}

}

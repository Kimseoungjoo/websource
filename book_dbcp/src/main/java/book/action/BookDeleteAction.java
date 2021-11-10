package book.action;

import javax.servlet.http.HttpServletRequest;

import book.service.BookDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookDeleteAction implements BookAction {
	private String path;
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// delete.jsp 에서 값받기
		String code = request.getParameter("code");
		//bookdeleteService에서 db작업 
		BookDeleteService service = new BookDeleteService();
		boolean deleteFlag = service.delete(code);
		
		if(!deleteFlag) {
			path = "/index.jsp?tab=delete";
		}
		return new BookActionForward(path, true);
	}

}

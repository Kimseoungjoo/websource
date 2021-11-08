package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookSearchService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookSearchAction implements BookAction {
	private String path;

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// search.jsp 에서 값 받아오기 
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		// bookSearchService 에서 db 작업 
		BookSearchService service = new BookSearchService();
		List<BookDTO> list  = service.search(criteria, keyword);
		
		request.setAttribute("list", list);
		
		if(list==null) {
			path = "/view/search.jsp";
		}
		return new BookActionForward(path,false);
	}

}

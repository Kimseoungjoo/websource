package book.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import book.domain.BookDTO;
import book.service.BookListService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookListAction implements BookAction {
	private String path; // "/view/all.jsp"

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		BookListService service = new BookListService();
		List<BookDTO> list = service.getList();

		request.setAttribute("list", list);
		
		return new BookActionForward(path, false); // setAttribute에 담으면 false로 보내라 (forward방식)
	}

}

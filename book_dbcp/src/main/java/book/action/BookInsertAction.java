package book.action;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookInsertService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookInsertAction implements BookAction {
	private String path;
	
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// insert.jspdptj 넘긴 값 가져오기
		
		BookDTO dto = new BookDTO();
		dto.setCode(request.getParameter("code"));
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		// serbice에게 db작업요청
		BookInsertService service = new BookInsertService();
		boolean insertFlag = service.bookInsert(dto);
		//결과에 따라서 페이지 이동
		if(!insertFlag) {
			path = "/index.jsp?tab=insert";
		}
		return new BookActionForward(path,true);
	}

}

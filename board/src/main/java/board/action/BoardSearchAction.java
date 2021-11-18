package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.SearchDTO;
import board.service.BoardSearchService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchAction implements BoardAction {
	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		// 검색 폼에서 넘긴 값 가져오기 
		SearchDTO dto = new SearchDTO();
		
		dto.setCriteria(request.getParameter("criteria"));
		dto.setKeyword(request.getParameter("keyword"));
		
		// service 요청
		BoardSearchService service = new BoardSearchService();
		List<BoardDTO> list =  service.search(dto);
	
		request.setAttribute("list", list);
		request.setAttribute("searchDto", dto);
		
		return new BoardActionForward(path,false);
	}

}

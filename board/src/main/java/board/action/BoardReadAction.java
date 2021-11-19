package board.action;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.domain.SearchDTO;
import board.service.BoardReadService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReadAction implements BoardAction {
	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		// list.do?bno = ?? bno 값 가져오기 
		// java.lang.NumberFormatException: null 
		int bno = Integer.parseInt(request.getParameter("bno"));
	
		// 페이지 나누기 후 추가 
		PageDTO pageDto = new PageDTO();
		
		pageDto.setPage(Integer.parseInt(request.getParameter("page")));
		pageDto.setAmount(Integer.parseInt(request.getParameter("amount")));
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		pageDto.setSearchDto(new SearchDTO(criteria,keyword));
		
		request.setAttribute("pageDto", pageDto);
		// -------------------------------------------------------
		
		// 서비스 요청 
		BoardReadService service = new BoardReadService();
		BoardDTO dto =  service.getRow(bno);
		
		// 이동 
		request.setAttribute("dto", dto);
		
		return new BoardActionForward(path,false);
	}

}

package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
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
	
		// 서비스 요청 
		BoardReadService service = new BoardReadService();
		BoardDTO dto =  service.getRow(bno);
		
		// 이동 
		request.setAttribute("dto", dto);
		
		return new BoardActionForward(path,false);
	}

}

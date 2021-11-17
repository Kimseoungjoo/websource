package board.action;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardCountUpdateService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardCountUpdateAction implements BoardAction {
	
	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		// list.do?bno = ?? bno 값 가져오기 
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 조회수 변경
		BoardCountUpdateService updateService = new BoardCountUpdateService();
		updateService.readUpdate(bno);
		path += "?bno="+bno;
		return new BoardActionForward(path,true);
	}

}

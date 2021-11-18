package board.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchAction implements BoardAction {
	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {

		return new BoardActionForward(path,true);
	}

}

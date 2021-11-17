package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardInsertService;
import board.utill.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardInsertAction implements BoardAction {
	private String path;

	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		// 해당 request를 UploadUtil에 넘기기
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);
		
		
		
		// Map에서 값 받아오기 
		BoardDTO dto = new BoardDTO();
		dto.setTitle(map.get("title"));
		dto.setName(map.get("name"));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		
		// 파일 첨부 
		dto.setAttach(map.get("attach"));
	
		BoardInsertService service = new BoardInsertService();
		
		boolean insertFlag = service.boardInsert(dto);
		
		if(!insertFlag) {
				path = "view/qna_board_write.jsp";
		}
		return new BoardActionForward(path,true);
	}

}

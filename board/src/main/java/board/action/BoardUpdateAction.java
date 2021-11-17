package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardUpdateService;
import board.utill.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements BoardAction {
	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		// 해당 request를 UploadUtil에 넘기기
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);
		
		// Map에서 값 받아오기 
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(map.get("bno")));
		dto.setTitle(map.get("title"));
		dto.setName(map.get("name"));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		// 파일 첨부 
		dto.setAttach(map.get("attach"));
		
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag = service.update(dto);
		
		if(updateFlag) {
			// path = read.do 
			path += "?bno="+dto.getBno();
		}else {
			path = "/modify.do?bno="+dto.getBno();
		}
		
		return new BoardActionForward(path,true);
	}

}

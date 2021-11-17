package board.action;

// 사용자의 요청에 따라 Action을 생성해주는 클래스
public class BoardActionFactory {
	// singleton pattern
	private static BoardActionFactory baf;
	private BoardAction action;
	
	// 생성자
	private BoardActionFactory() {}
	// baf 생성해주는 메소드
	public static BoardActionFactory getInstance() {
		if(baf==null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	public BoardAction action(String cmd) {
		if(cmd.equals("/insert.do")) {
			action = new BoardInsertAction("/list.do");
		}else if(cmd.equals("/list.do")) {
			action = new BoardListAction("/view/qna_board_list.jsp");
		}else if(cmd.equals("/read.do")) {
			action = new BoardReadAction("/view/qna_board_view.jsp");
		}else if(cmd.equals("/countUpdate.do")) {
			action = new BoardCountUpdateAction("/read.do");
		}else if(cmd.equals("/remove.do")) {
			action = new BoardRemoveAction("/list.do");
		}else if(cmd.equals("/modify.do")) {
			action = new BoardReadAction("/view/qna_board_modify.jsp");
		}else if(cmd.equals("/update.do")) {
			action = new BoardUpdateAction("/read.do");
		}
		
		
		return action;
	}

}

package board.action;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 이동경로와 이동 방식을 저장하는 클래스

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardActionForward {
	private String path;
	private boolean redirect;
}
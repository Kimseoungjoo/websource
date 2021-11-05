package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ActionForward {
	// 이동경로와 이동 방식을 저장 하는 클래스 
	private String path;
	private boolean redirect; // true(sendRedirect방식), false(forward방식) 으로 보내겠다
	
}

package member.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이동경로와 이동방식 저장
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActionForward{
	private String path;
	private boolean redirect;
}

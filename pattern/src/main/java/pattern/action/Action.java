package pattern.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
	public ActionForward excute(HttpServletRequest request) throws Exception; 
}

package member.controller;

import member.action.Action;
import member.action.LoginAction;

public class MemberActionFactory {
	//singleton 객체 생성
	
	private static MemberActionFactory maf;
	private Action action;
	
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(maf==null) {
			maf = new MemberActionFactory();
		}
		return maf;
	}
	public Action action(String cmd) {
		
		if(cmd.equals("/login.do")) {
			action = new LoginAction("/view/loginForm.jsp");
		}
		
		return action;
	}
}

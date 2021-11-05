package pattern.service;

public class InsertService {
	
	public boolean loginService(String userid, String password) {
		// db작업 !!은 service패키지에서 = > 비지니스 로직(MVC M)
		
		boolean loginFlag = false;

		
		System.out.println("userid : "+userid);
		System.out.println("password: "+password);
		
		return loginFlag;
		
	}
}

package project.jdbc.controller;



import java.util.Date;

import project.jdbc.service.MembershipService;


public class SignUpController {

	public void getResult(String id, String pw, String name, String birth, String phone, String email, Date regdate) {
	    MembershipService service = new MembershipService();
	    service.insertMemberInfo(id,pw,name,birth,phone,email,regdate);
	    
	    
	}
}

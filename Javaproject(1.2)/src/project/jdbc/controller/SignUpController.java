package project.jdbc.controller;

import project.jdbc.service.MembershipService;


public class SignUpController {

	public void getResult(String id, String pw, String name, String birth, String phone, String email) {
	    MembershipService service = new MembershipService();
	    service.insertMemberInfo(id,pw,name,birth,phone,email);
	    
	    
	}
}

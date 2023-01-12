package project.jdbc.controller;

import project.jdbc.service.MembershipService;

public class MyInfoEditController {

	public void getResult(String id, String pw, String name, String birth, String phonenumber, String email,String loginId) {
		    MembershipService service = new MembershipService();
		    service.updateMemberInfo(id,pw,name,birth,phonenumber,email,loginId);
		
	}


}

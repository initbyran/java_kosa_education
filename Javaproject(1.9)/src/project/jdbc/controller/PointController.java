package project.jdbc.controller;

import project.jdbc.service.MembershipService;

public class PointController {

	public void getResult(String loginId) {
		MembershipService service = new MembershipService();
		service.updateReturnPoint(loginId);
		
	}

	public void getResult2(String loginId) {
		MembershipService service = new MembershipService();
		service.updateOverduePoint(loginId);
		
	}

	public int getResult3(String loginId) {
		MembershipService service = new MembershipService();
			return service.selectPoint(loginId);
	}

	
}

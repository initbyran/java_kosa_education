package project.jdbc.controller;

import project.jdbc.service.MembershipService;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;

public class LoginController {
	
	public boolean getResult(String loginId, String loginpw) {
		
		MembershipService service = new MembershipService();
		boolean b = service.selectMemberByID(loginId, loginpw);
		return b;
	}

	public RentalInfoVO getResult2(String loginId) {
		
		RentalInfoVO manager = new RentalInfoVO();
		MembershipService service = new MembershipService();
		manager = service.selectManagerByID(loginId);
		return manager;
	}
}

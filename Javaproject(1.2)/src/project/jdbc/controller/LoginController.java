package project.jdbc.controller;

import project.jdbc.service.MembershipService;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;

public class LoginController {
	
	public MembershipVO getResult(String loginId) {
		MembershipVO membership = new MembershipVO();
		MembershipService service = new MembershipService();
		membership = service.selectMemberByID(loginId);
		return membership;
	}

	public RentalInfoVO getResult2(String managerId) {
		RentalInfoVO manager = new RentalInfoVO();
		MembershipService service = new MembershipService();
		manager = service.selectManagerByID(managerId);
		return manager;
	}
}

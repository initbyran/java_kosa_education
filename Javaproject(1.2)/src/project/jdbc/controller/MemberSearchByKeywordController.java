package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.MembershipService;
import project.jdbc.vo.MembershipVO;

public class MemberSearchByKeywordController {

	public ObservableList<MembershipVO> getResult(String text) {
		MembershipService service = new MembershipService();
		ObservableList<MembershipVO> list = service.selectMemberByKeyword(text);
		
		return list;
	}

	public MembershipVO getResult2(String loginId) {
		MembershipVO membership = new MembershipVO();
		MembershipService service = new MembershipService();
		membership = service.selectMember(loginId);
		
		return membership;
	}

	
}

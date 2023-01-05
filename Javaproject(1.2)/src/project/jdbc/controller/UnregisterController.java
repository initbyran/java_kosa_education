package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.MembershipService;
import project.jdbc.vo.MembershipVO;

public class UnregisterController {

	public ObservableList<MembershipVO> getResult(String loginId) {
		MembershipService service = new MembershipService();
		ObservableList<MembershipVO> list = service.deleteMember(loginId);
	    return list;
	}

}

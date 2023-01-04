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

}

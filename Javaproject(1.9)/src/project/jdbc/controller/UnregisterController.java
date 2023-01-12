package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.service.MembershipService;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;

public class UnregisterController {

	public ObservableList<MembershipVO> getResult(String loginId) {
		MembershipService service = new MembershipService();
		ObservableList<MembershipVO> list = service.deleteMember(loginId);
	    return list;
	}

	public BookVO getResult2(String loginId) {
		BookVO book = new BookVO();
		BookService service = new BookService();
		book = service.selectBorrowed(loginId);
		return book;
	}

}

package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BorrowedBookListController {

	public ObservableList<BookVO> getResult(String loginId) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectBookrental(loginId);
		
		return list;
	}

}

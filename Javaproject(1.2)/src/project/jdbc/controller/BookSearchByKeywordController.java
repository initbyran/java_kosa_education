package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BookSearchByKeywordController {

	public ObservableList<BookVO> getResult(String text) {
        BookService service = new BookService();
        ObservableList<BookVO> list = service.selectBookByKeyword(text);
		return list;
	}

}

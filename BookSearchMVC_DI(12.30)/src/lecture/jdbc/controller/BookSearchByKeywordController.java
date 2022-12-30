package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

// controller : view와 service model와 연결
public class BookSearchByKeywordController {

	public ObservableList<BookVO> getResult(String text) {
	
		// service instance
		BookService service = new BookService();
		// transaction으로 처리
		ObservableList<BookVO> list = service.selectBooksByKeyword(text);
		
		return list;

	}

}

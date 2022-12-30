package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

public class BookDoubleClickDialogController {
	
	public ObservableList<BookVO> getResult(String clickedRowData) {
		
		// service instance
		BookService service = new BookService();
		// transaction으로 처리
		ObservableList<BookVO> list = service.doubleClickDialog(clickedRowData);
		
		return list;

	}
}

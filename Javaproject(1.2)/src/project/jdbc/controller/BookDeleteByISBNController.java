package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BookDeleteByISBNController {

	public ObservableList<BookVO> getResult(String deleteISBN, String searchKeyword) {
	
		BookService service = new BookService();
		ObservableList<BookVO> list = 
				service.deleteByISBN(deleteISBN, searchKeyword);
		return list;
}
	public ObservableList<BookVO> getResult2(String loginId) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.deleteByRisbn(loginId);
		return list;
	}

}
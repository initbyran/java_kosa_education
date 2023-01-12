package project.jdbc.controller;

import java.util.List;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BookDeleteByISBNController {

	public List<BookVO> getResult(String deleteISBN, String searchKeyword) {
	
		BookService service = new BookService();
		List<BookVO> list = 
				service.deleteByISBN(deleteISBN, searchKeyword);
		return list;
}
	public ObservableList<BookVO> getResult2(String risbn, String loginId) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.deleteByRisbn(risbn, loginId);
		return list;
	}

}
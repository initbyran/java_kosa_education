package project.jdbc.controller;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.service.MembershipService;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;

public class BookSearchByKeywordController {

	public ObservableList<BookVO> getResult(String text) {
        BookService service = new BookService();
        ObservableList<BookVO> list = service.selectBookByKeyword(text);
		return list;
	}
	
//	public ObservableList<BookVO> getResult2(String risbn) {
//        BookService service = new BookService();
//        ObservableList<BookVO> list = service.updateByRisbn(risbn);
//		return list;
//	}
//	
	public BookVO getResult3(String updateISBN) {
		BookVO book = new BookVO();
		BookService service = new BookService();
		book = service.selectB(updateISBN);
		
		return book;
	}

	
	public  BookVO getResult4(String risbn) {
		
		BookService service = new BookService();
		BookVO book = service.selectOverdueBook();
		
		return book;
	}

	public ObservableList<BookVO> getResult5() {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectOverdueBookList();
		
		return list;
	}
	
}

package project.jdbc.controller;

import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BookDetailByISBNController {

	public BookVO getResult(String bisbn) {
		BookService service = new BookService();
		BookVO book = service.selectDetailsByKeyword(bisbn);
		
		return book;
	}

}

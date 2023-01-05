package project.jdbc.controller;

import project.jdbc.service.BookService;

public class BookEditController {

	public void getResult(String isbn, String title, String author, String publisher, String date, int page,
			String translator, String updateISBN) {
		BookService service = new BookService();
		service.updateBookInfo(isbn,title,author,publisher,date,page,translator,updateISBN);
		
		
	}

}

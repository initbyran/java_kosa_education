package project.jdbc.controller;

import project.jdbc.service.BookService;

public class AddBookController {

	public void getResult(String isbn,String title,String author,String publisher,String date,String page,String translator) {
		BookService service = new BookService();
		service.insertBook(isbn,title,author,publisher,date,page,translator);
	}

}

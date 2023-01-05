package project.jdbc.controller;

import java.util.Date;

import javafx.collections.ObservableList;
import project.jdbc.service.BookService;
import project.jdbc.vo.BookVO;

public class BorrowBookController {

	public void getResult(String isbn, String title, String author, String publisher, String id, Date date, Date duedate) {
		BookService service = new BookService();
		service.insertRentalInfo(isbn,title,author,publisher,id,date,duedate);
	
	}

	public ObservableList<BookVO> getResult2(String borrowedISBN,String searchKeyword) {
		BookService service = new BookService();
		ObservableList<BookVO> list = 
				service.updateByISBN(borrowedISBN, searchKeyword);
		return list;
	}

	
	
}

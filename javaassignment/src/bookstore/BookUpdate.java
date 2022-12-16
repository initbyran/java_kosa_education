package bookstore;

import bookstore.Book;

public class BookUpdate {

	private Book bookData;

	public Book getBookData() {
		return bookData;
	}

	public void setBookData(Book bookData) {
		this.bookData = bookData;
	}

	public BookUpdate() {
		
	}

	public BookUpdate(Book bookData) {
		super();
		this.bookData = bookData;
	}
	
	public void UpdateBookPrice() {
		bookData.setBookPrice(bookData.getDiscountBookPrice());
		
	}
	
}

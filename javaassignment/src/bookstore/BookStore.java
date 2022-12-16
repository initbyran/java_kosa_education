package bookstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStore {

	public static void main(String[] args) {
	
		Book b1 = new Book ("IT","HTML5",30000,15);
		
		BookUpdate b2 = new BookUpdate(b1);
		
		System.out.println("기본정보");
		System.out.println(b2.getBookData().getBookName()+"\t"
		+ b2.getBookData().getBookPrice());
		System.out.println("변경된 정보");
		System.out.println(b2.getBookData().getBookName()+"\t"
				+ b2.getBookData().getDiscountBookPrice());
		
		
		
}
}

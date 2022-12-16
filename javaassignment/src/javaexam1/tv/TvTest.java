package javaexam1.tv;

import java.util.Arrays;

import bookstore.Book;

public class TvTest {

	public static void main(String[] args) {
		
		Tv tvarray[] = new Tv [3];
		
		tvarray[0] = new Tv ("INFINIA",1500000,"LED TV");
		tvarray[1] = new Tv ("XCANVAS",1000000,"LCD TV");
		tvarray[2] = new Tv ("CINEMA",2000000,"3D TV");
		
		int sum = 0;
		  
		for(Tv tv : tvarray) {
	           System.out.println(tv);
	
	           sum += tv.getPrice();
	  
	       }
		   System.out.println("가격의 합 : "+sum);
	}

}

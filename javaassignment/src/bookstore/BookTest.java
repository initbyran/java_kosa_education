package bookstore;


public class BookTest {

	public static Object bookaray;
	

	public static void main(String[] args) {
       
       Book bookArray[]=new Book[5];
       
       bookArray[0] = new Book ("IT","SQL Plus",50000,5);
       bookArray[1] = new Book ("IT","Java 2.0",40000,3);
       bookArray[2] = new Book ("IT","JSP Servlet",60000,6);
       bookArray[3] = new Book ("Nobel","davincicode",30000,10);
       bookArray[4] = new Book ("Nobel","cloven hoof",50000,15);
       
       for(Book book : bookArray) {
           System.out.println(book.toString());
       }
           double sum = 0;       
    	   double sum1 = 0;
    	   double sum2 = 0;       
    	   double sum3 = 0;
    	   
         for(Book book : bookArray) {
        	
    	 if (book.getCategory().equals("IT")) {    		  
    		    sum +=book.getBookPrice();             
    		    sum1 +=book.getDiscountBookPrice();
              
    	 }
    	 
    	 else {   		 
    		 sum2 +=book.getBookPrice();
 		    sum3 +=book.getDiscountBookPrice(); 
    	 }
    	 
    	
	}
         
          System.out.println("IT Category의 책 가격 합 : " +sum +"원");
          System.out.println("IT Category의 할인된 책 가격 합 : " +sum1+"원");
          System.out.println("Nobel Category의 책 가격 합 : " +sum2 +"원");
          System.out.println("Nobeel Category의 할인된 책 가격 합 : " +sum3+"원");


}
}
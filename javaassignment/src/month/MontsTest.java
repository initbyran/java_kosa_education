package month;

public class MontsTest {

	public static void main(String[] args) {
	
		int month;
		
		month = Integer.parseInt(args[0]);
		
		
        System.out.println("입력받은월 : "+month+"월");	
        
     if (args.length > 1) { 
    	 System.out.println("다시 입력해주세요!");
     }
	 
     if (month > 12) {
    	 System.out.println("입력된 값이 잘못되었습니다!");
    	 return;
     }
     
    Months m = new Months();
    
	int days = m.getDays(month);
	
 	 System.out.println("마지막일자 : " + days +"일");
	
	}


}

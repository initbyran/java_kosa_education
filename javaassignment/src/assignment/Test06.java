package assignment;

public class Test06 {

	public static void main(String[] args) {
	     int a[] = new int [5];
	    		 
	     for (int i=0;i<5;i++) {
	    	 a[i] = Integer.parseInt(args[i]);
	     }
	     
		 
		 if (!(args.length == 5)) {
			 System.out.println("다시 입력하세요!");
		 }
		 
		 for (int i=0;i<5;i++) {
			 	 if (!(a[i]>=10) && !(a[i]>=99)) {
			 System.out.println("다시 입력하세요!");
		 }
		 
		 }
	
		 
		 double f = (((a[0]+a[1])/2)*0.6)+(((a[2]+a[3])/2)*0.2)+(a[4]*0.2);
		
		 System.out.println("평가점수 : "+f+"점");
		 
		 String aa;
		 
		 if (f>=90)  {
			 aa = "Gold Class";
		 } else if(f>=80) {
			 aa = "Silver Class";
		 } else if(f>=70) {
			 aa = "Bronze Class";
		 } else {
			 aa = "Normal Class";
		 }
		  
		 System.out.println("Class : "+ aa);

	}

	
	
}

package assignment;

public class Test02 {

	public static void main(String[] args) {
	  
		int a;
		int result = 1;
		a = Integer.parseInt(args[0]);
		
		for (int i=1 ; i<= a ; i++) {
			result*=i;
		}
		
	System.out.println(result);
	} 
}
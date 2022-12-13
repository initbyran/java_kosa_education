package assignment;

public class Test05 {

	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		c = Integer.parseInt(args[2]);

		System.out.println("입력값 : "+a+" "+b+" "+c);
			
		int max = Integer.parseInt(args[0]);
		for(int i=1; i<args.length; i++) {
			if(max < Integer.parseInt(args[i])) { 
				max = Integer.parseInt(args[i]);
			}
		}
		System.out.println("최대값 : "+max);				
		
		int min = Integer.parseInt(args[0]);
		for (int i=1; i < args.length; i++) {
			if(min > Integer.parseInt(args[i])) {
				min = Integer.parseInt(args[i]);
			}
		}
		System.out.println("최소값 : "+min);
}
}

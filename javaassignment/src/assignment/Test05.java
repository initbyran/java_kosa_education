package assignment;

public class Test05 {

	public static void main(String[] args) {
		
		int a[] = new int[3];
		
		a[0] = Integer.parseInt(args[0]);
		a[1] = Integer.parseInt(args[1]);
		a[2] = Integer.parseInt(args[2]);
		
		System.out.println("입력값 : "+a[0]+" "+a[1]+" "+a[2]);
			
	
		
		int max = a[0];
		for(int i=1; i<args.length; i++) {
			if(max < a[i]) { 
				max = a[i];
			}
		}
		System.out.println("최대값 : "+max);				
		
		int min = a[0];
		for (int i=1; i < args.length; i++) {
			if(min > a[i]) {
				min = a[i];
			}
		}
		System.out.println("최소값 : "+min);
}
}

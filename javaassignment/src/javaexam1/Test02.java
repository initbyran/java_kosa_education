package javaexam1;

public class Test02 {

	public static void main(String[] args) {
	  
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		if (a>=0 && a<10) {
			if(b>=0 && b<10) {
				if(a*b<10) {
					System.out.println("한자리 수 입니다.");
				} else {
					System.out.println("두자리 수 입니다.");
				}
			}
		}

	}

}

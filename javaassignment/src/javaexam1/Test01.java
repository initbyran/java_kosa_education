package javaexam1;

public class Test01 {

	public static void main(String[] args) {
	
		int a = Integer.parseInt(args[0]);
		
		if(a>=1 && a<=100) {
			if(a%2==0) {
				System.out.println("2의 배수입니다.");
			} else {
				System.out.println("2의 배수가 아닙니다.");
			}
		}
}
}

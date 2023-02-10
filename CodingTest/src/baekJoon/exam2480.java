package baekJoon;

import java.util.Scanner;

public class exam2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A==B && B==C && C==A) {
            int max = A;
			System.out.println(10000+(A*1000));
		} else if(A!=B && B!=C && C!=A ){
		    int num = Math.max(A,B);
		    int maximum = Math.max(num, C);
		    System.out.println(maximum*100);
		    
		} else {
			if(A==B) {
				System.out.println(1000+(A*100));
			} else if(B==C) {
				System.out.println(1000+(B*100));
			} else {
				System.out.println(1000+(C*100));
			}
			
		}
	}

}

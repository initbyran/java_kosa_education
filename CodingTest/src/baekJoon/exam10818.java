package baekJoon;

import java.util.Scanner;

public class exam10818 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int num[] = new int[A];
		for(int i=0; i<A ; i++) {
			  int N = sc.nextInt();
			  num[i]=N;
		}
		
        int max = num[0];
		for(int j=0; j<num.length ; j++) {
			if(num[j]>max) {
				max=num[j];
			}
		}
		
		 int min = num[0];
			for(int k=0; k<num.length ; k++) {
				if(num[k]<min) {
					min=num[k];
				}
			}
		
		
		System.out.println(min+" "+max);
	}

}

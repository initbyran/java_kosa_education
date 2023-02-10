package baekJoon;

import java.util.Scanner;

public class exam4344 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		if(C>=1 && C<=100){
			for(int i=1; i<=C; i++) {
					int N = sc.nextInt();
					int arr[]=new int[N];
					for(int j=0; j<N; j++) {
							int num=sc.nextInt();
							arr[j]=num;
				    }
					int sum=0;
					
				    int count = 0;
					for(int k=0; k<arr.length; k++) {
						sum+= arr[k];
					}
					float avg = (float)sum/(float)N;
					for(int m=0; m<arr.length; m++) {
						
						if(arr[m]>avg) {
							count++;
						}}
					
				    float result = (float)Math.round(((float)count/(float)N)*100000)/1000;
				    
				    
				    System.out.println( String.format("%.3f", result)+"%");
			}
		}
		
		
	}

}

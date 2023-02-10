package baekJoon;

import java.util.Scanner;

public class exam2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
       for(int k=1; k<=N; k++) { 
    	   for(int j=1; j<=N-k ; j++) {
        	System.out.print(" ");}
        	for(int i=1; i<=k; i++) {
             System.out.print("*"); }
           
	    System.out.println();
       };
       
	}}


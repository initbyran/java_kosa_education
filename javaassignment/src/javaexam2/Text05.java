package javaexam2;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Text05 {

	public static void main(String[] args) {
		
		HashMap <Integer,Integer> map = new HashMap <Integer,Integer>();
		
		for (int i=1; i<11; i++) {
			map.put(i, (int)(Math.random()*100+1));
		}
	    
		for (int j : map.values()) {
			System.out.print(j+" ");
		}
		
		double sum=0;
		
		for (int k : map.values()) {
			sum += k;			
		}
	
		double average = sum/map.size();
		
		DecimalFormat df = new DecimalFormat ("0.00");
		
		
		System.out.println("");
	    System.out.println("합계 : " +df.format(sum));
	    System.out.println("평균 : " +df.format(average));
	    
	
		
		
	}


}

package javaexam2;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Test03 {

	public static void main(String[] args) {
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data [] = new double [5];
		double sum=0;
		double average=0;
			
		StringTokenizer st = new StringTokenizer(str,",");
		int count = st.countTokens();
		
		for(int i=0; st.hasMoreElements();i++) {
			sum += Double.parseDouble(st.nextToken());		
		} 
		
		DecimalFormat df = new  DecimalFormat("0.000");
		
		
        average = sum / count;
        
		System.out.println("합계 : "+df.format(sum));
		System.out.println("평균 : "+df.format(average));
	}

}
		 
	
		
		

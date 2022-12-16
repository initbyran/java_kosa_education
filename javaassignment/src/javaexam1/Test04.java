package javaexam1;

public class Test04 {

	public static void main(String[] args) {
		
		int a = 0;
        double sum = 0;
       
        
		while (a<=100) {
			sum += (double) a;
            a++;
		}
		
		 double avr = sum/(a-1);
		
		System.out.println("합계 : " + sum);
        System.out.println("평균 : "+ avr);
	}

}

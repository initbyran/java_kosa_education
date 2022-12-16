package javaexam1.calc;

public class CalcTest {

	public static void main(String[] args) {
		  
		Calc calc = new Calc();
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		
		if(a>=1 && a<10) {
		   System.out.println("합 : "+Calc.sum(a,b));
		   System.out.println("차 : "+Calc.subtract(a,b));
		   System.out.println("곱 : "+Calc.multiply(a,b));
		   System.out.println("나누기 : "+Calc.divide(a,b));
		}
		}

}

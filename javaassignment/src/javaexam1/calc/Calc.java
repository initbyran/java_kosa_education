package javaexam1.calc;

public class Calc {
	
	public Calc () {
	}
	
	public static int sum (int a, int b) {
		int result = a + b;
		return result;
	}
	
	public static int subtract (int a, int b) {
        int result = a - b;
        return result;
	}

	
	public static int multiply (int a, int b) {
		int result = a * b;
		return result;
	}
	
	
	public static int divide (int a, int b) {
		if(b>0) {
			int result = a/b;
			return result;
		} else {
			return 0;
		}
		
	}
}

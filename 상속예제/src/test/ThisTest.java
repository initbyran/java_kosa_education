package test;

public class ThisTest extends Object {

	// 1. constructor
	public ThisTest() {
		// default constructor 항상 명시적으로 작성
		this(100); // this()는 현재 class의 다른 생성자를 호출할 떄 사용. 
	}
	
	// constructor overloading으로 또 다른 생성자르 하나 만들어요.
	public ThisTest(int k) {
		super(); // 상위 class의 생성자를 호출할 떄 사용.
		System.out.println("인자가 하나있는 생성자!");
	}
	// 2. field - 존재 없음
	
	// 3. method
    public static void main(String[] args) {
    	ThisTest a = new ThisTest();
    }
	
}

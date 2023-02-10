package finaltest;

// java finaltest.Subclass => 실행
// class에 대한 정보가 method area에 올라가야해요.

// 상위 class의 정보부터 먼저 method area에 올려야해요.
// main method 호출 ; entry point
public class SubClass extends SuperClass {

	
	// 1. constructor
     public SubClass() {
    	 super(100);
       // constructor super or this가 꼭 나옴
    	 //숫자 인자를 가진 상위 클래스 호출
    	 
    	// instance를 위해 메모리에 공간을 확보 -> field를 위한 공간 ; 6번 출력!
    	 staticCall("8번 문장입니다.!");
    	 super.myFunc();
     }
	// 2. field
	 int c = staticCall("6번 문장입니다.!");
	 // 공간 형성 -> 생성자 호출
     static int d = staticCall("7번 문장입니다.!");

     // 3. method
	 // method overriding
 	@Override // annotation
 	public void myFunc() {
 		System.out.println("9번 문장입니다.!");
 	}

 	public static void main(String[] args) {
		System.out.println("10번 문장입니다.!");
	    SuperClass obj = new SubClass();
	    // instance 생성, 초기화 필요 -> 생성자 호출 
	    // obj = local variable, reference variable
	    obj.myFunc();
 	}
}

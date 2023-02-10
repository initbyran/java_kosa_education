package finaltest;

public class SuperClass {

	// 1. constructor
	public SuperClass() {
		// super(); 생략되어있음 - 상위 클래스의 instance 생성부분;object
        // instance를 위해 메모리에 공간을 확보 -> field를 위한 공간 ; 1번 출력!
		// 우리 객체의 초기화 진행
		staticCall("3번 문장입니다.!");
	}
	// constructor overloading - 인자 하나 있음 
	public SuperClass(int i) {
		this(); // 현재 class에 다른 생성자를 호출하는 기능.->staticCall("3번째 문장입니다.!")
		staticCall("4번 문장입니다.!");
	// 숫자가 인자로 있는 생성자 호출 -> this라는 것 때문에 상위 다른 생성자 먼저 호출 -> 그러나 초기화를 할 공간이 먼저 필요
	}
	
	
	// 2. field ; 기본적으로 private으로 설정.
	int a = staticCall("1번 문장입니다.!");
	// a라는 field는 instance가 생성되어야 공간이 실제로 만들어지고 사용할 수 있어요 ; instance variable
	// 만들어지는 공간 : heap
	// 먼저 이 공간이 생성되고 생성자 호출 실행.
	static int b = staticCall("2번 문장입니다.!");
	// b라는 field는 instance가 없어도 사용 가능 ; class variable  
	// 만들어지는 공간 : method area
	
	// 3. method
	// 일반적으로 public으로 지정.
	// static - instance가 없어도 호출 가능.
	
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100; // void는 return값이 없지만, int는 return 값 필요하므로 반드시 명시.
	// method return ; 결과값을 리턴한다는 의미는 메소드를 호출한 곳으로(field의 "1번 문장입니다.") 값을 대치한다는 의미.
		
	}
	
	public void myFunc() {
	     System.out.println("5번 문장입니다.!");	
	}
}

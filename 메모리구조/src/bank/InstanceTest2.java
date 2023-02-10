package bank;

public class InstanceTest2 {

	// field
	static int a = staticCall("1번째 출력입니다.");
	int b = staticCall("2번쨰 출력입니다.");
	
	// method
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100; 
	}
	
	// static block 
	// 이 static block은 언제 실행되나요? -> main method 실행 이전에 실행 가능 
	// 순서 1-static block-4-5-2-3
	// 프로그램에서 사용되는 라이브러리(JNI ; 다른 언어로 만든 라이브러리 연동할 때)를를 미리 로딩하고자할때 사용.
	static {
		System.out.println("static block입니다. a의 값은 : " + a);
	}
	
	//생성자
	public InstanceTest2() {
		this.b = staticCall("3번째 출력입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("4번째 출력입니다.");
		int c = staticCall("5번째 출력입니다.");
		InstanceTest2 d = new InstanceTest2();
	}
}
   // 순서 1(method area 정보 업로드 끝)-4-5-instance생성(초기화)-2-3
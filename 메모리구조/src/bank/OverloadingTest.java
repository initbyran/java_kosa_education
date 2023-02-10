package bank;

public class OverloadingTest {

	//1. constructor
	//   instance를 생성할 때 초기화해주는 역할을 담당! (객체 초기화)

	public OverloadingTest() {
		//default constructor
		// Java의 모든 class는 default 생성자를 가질 수 있도록 코드를 작성!
		
	}
    // constructor overloading
	public OverloadingTest(String a, String b, int c) {
		// a,b,c : parameter(형식인자) = formal parameter
		this.name = a;
		this.mobile = b;
		this.age = c;
	}
	//2. field
    public String name;
    public String mobile;
    public int age;
    
	//3. method
    public static void main(String[] args) {
    	// arguments(실인자)=actual parameter : "홍길동","010-1111-2222",20
    	OverloadingTest tmp = new OverloadingTest("홍길동","010-1111-2222",20);
    	//인스턴스가 만들어지면 instance안에 name, mobile, age의 공간이 생성.
    	//이 공간은 해당 데이터 타입으로 각각 초기화가 진행.
        //name => ""(empty string) 공백문자열.
    	//age => 0으로 초기화
    	//tmp.name = "홍길동";
        //tmp.mobile = "010-1111-2222";
        //tmp.age = 20;
    }
}

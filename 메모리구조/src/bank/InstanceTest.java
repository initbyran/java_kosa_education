package bank;

    
    // javac InstanceTest.java => compile한 후
    // java bank.InstanceTest => JVM을 이용해서 실행
public class InstanceTest {

	// 1. 생성자
	public InstanceTest() {
		
	}
	// 2. field
	
	static int a = 100;
	// static이 붙으면 a라는 공간이 이미 method area 실제로 생김 -> 그 공간에 100이 채워짐
    // -instance 를 만들지 않고도 사용할 수 있어요.
	// class variable
	int b = 200;
    // b는 instance가 생성되면 heap에 공간이 생김
    // instance variable
    
	// 3. method
	public void instanceCall(String msg) {
		System.out.println(msg);
	}
	//instance가 있어야해요.
	
	public static void staticCall(String msg) {
		System.out.println(msg);
	}
	//instance가 없어도 쓸 수 있어요.
	
	public static void main(String[] args) {
		int k = 100; //local variable  지역변수 (stack에 저장되고 method 종료하면 당연히 없어져요)
		InstanceTest hong = new InstanceTest();
		
		hong.a = 300; //instance를 이용해서 static field를 사용할 수 있어요.
        InstanceTest.a = 500; // static field이기 때문에 class를 이용해서 사용할 수 있어요.
	    
        hong.b = 300; //ok
        InstanceTest.b = 500; //error
	}
}

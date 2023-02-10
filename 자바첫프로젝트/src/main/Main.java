package main;

import test.Customer;

public class Main {

	public static void main(String[] args) {
		// 프로그램의  entry point
		System.out.printIn("프로그램 시작!");
		
		Customer hong = new Customer(); //reference data type
		//hong => reference variable(참조 변수)
		// 메모리 주소에 대한 참조값(해쉬값)이 들어가 있기 때문에 이 변수를 이렇게 부른다.
		// instance는 메모리에 존재해요!(메모리 공간 중 어디에 위치하나? -> Heap이라고 불리는 영역에 존재)
		// 우리가 사용하는 건 결국 instance를 사용하는 거예요. 이 공간을 사용하기 위해 참조변수를 이용.
		// 일반적으로 hong 을 객체라고 부름.
		hong.balance = 1000;
		
		Customer shin = new Customer();
		
		int k = 100; // primitive data type
}

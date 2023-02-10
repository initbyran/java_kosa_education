package com.test2;

class Customer{
	
	public String name;
	public long balance;
	
}
public class ExceptionTest {

	//public static void main(String[] args) throws Exception {
	public static void main(String[] args) {
	 System.out.println("예외상황을 발생시켜요!");
	
//	 Customer a = null; // reference variable이 가르키는 instance가 heap 영역에 없다.
//	 a.name = "홍길동";
	 
	try { int result = 10 / 0 ; // 문법적인 오류는 없으나 Run time에 exception 발생.
	} 	
	
	//catch (Exception e) {
		// 이렇게 쓰면 뒤에 과정이 처리되지 않음. 하위 -> 상위
	//}
	
	catch (NullPointerException e) {
		System.out.println("NullpointerException");
		//  원래는 예외사항 처리 코드가 들어오는 자리
	}
	
	catch (Exception e) {
		System.out.println("Exception");
	}
	
	finally{ 
	// 무조건 실행
		System.out.println("여기는 출력되나요?");
	}

	}
	
	
}

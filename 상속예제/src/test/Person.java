package test;

// import java.lang.*; // 기본적으로 생략이 가능

public class Person { // extends Object 생략 가능

	// 1. constructor
	public Person() {
		super(); //현재 class의 상위 class인 Object class의 생성자를 호출.
		         //Object()가 호출되어서 실행.
		//인자도 받아들이지 않고 하는 일도 없는 default constructor
		
		// 자신의 초기화를 진행해야해요.
		this.name = name;
		System.out.println("person의 생성자가 호출돼요!!");
	}
	// 2. field
	private String name;
	private String gender;
	private int age;
	
	// 3. method
	// business logic method
	public void eat() {
		System.out.println("밥을 먹어요!");
	}
}

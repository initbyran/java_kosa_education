package com.test;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동",20);
		Student s2 = new Student("홍길동",20);
		
		// 두 객체가 같은 객체인가요?
	//		1. 진짜 두개의 instance가 같은 메모리 공간을 공유?
	//		2. instance 의 내용이 같은가요?
		System.out.println(s1==s2);
		// 비교 연산자 "==" - true, false
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.toString());
	}

}

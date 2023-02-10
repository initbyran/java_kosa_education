package test;

import java.lang.String;
    //package명 이제 생략가능. 앞으로 string은 package명 안쓸게요.

import java.lang.*;
    //java.lang.안의 모든 것 package 생략가능

public class Customer {

	// class - pascal case notation
	
	// 1. 생성자들
	//    class안에 있는 생성자를 이용해서 class로부터 instance를 생성.
	// 일단 public, method형태(method는 아님 -> 리턴타입 존재하지 않아요.)
	// 생성자 이름은 class이름으로 정해져있음.
	// 입력인자(parameter)를 가질 수 있어요.
	// 중괄호안에 instance 의 초기화 코드가 들어와요.
	
	public Customer() {
        // 생성될 instance의 초기화코드가 들어옴.
	}
	
	// 2. field들
	// 변수 => camel case notation
	java.lang.String customerName; // 고객이름
	public long balance; // 잔액 (int range : -21억~21억->long)
	java.lang.String customerAccount; // 고객 계좌번호
	int customerAge;
	// string : reference data type -> class(java가 프로그램을 쉽게 하기 위해 제공하는 class 매우 많다 - class library ; package로 묶어서 제공)
	// int, long : primitive data type
	
	// 3. method들
	// 일반적으로 method는 특별한 용도가 아닌 이상 public을 기본으로 지정.
	public int getAge(int kk) {
		// kk는 parameter라고 하고 method의 입력을 받아들이는 역할을 수행.
		// business logic 처리가 진행돼요.
		System.out.printIn("나이를 알려주는 기능이예요!");
		// if, for, ...
		return 30;
	}
}

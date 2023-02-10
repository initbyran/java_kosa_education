package bpackage;
//package 구문이 무조건 최상단

import apackage.*;
//여러개 나올 수 있음

class BClass {

	// 1. constructor
	 BClass() {
		//default  constructor
	}
	
	// 2. field
	private int bField;
	// 우리 class내에서만 조회, 변경 가능하도록 처리
	// 특수한 목적의 method 통해 접근 가능하도록 함 
	// 하나의 private field의 값을 조회하는 목적을 가진 method : getter
	// 다른 하나는 private field의 값을 변경하는 목적을 가진 method : setter
    // getter : 외부에서 접근이 가능한 method 활용 -> public (access modifier)
	//   -> 명명법 get + 대문자첫글자로 바꾼 필드명
	//public int getBField() {
	//	return this.bField;}
	// setter : set + 필드명
	// public void setBField(int bField) {
	//	this.bField = bField;}
	
	// 3. method
	void bMethod() {
		System.out.println("하이하이!");
	}

	public int getbField() {
		return bField;
	}

	public void setbField(int bField) {
		this.bField = bField;
	}
}

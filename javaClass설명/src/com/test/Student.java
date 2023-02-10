package com.test;

import java.lang.*; //기본적으로 삽입. 안써도 자동으로.

public class Student extends Object {

	// constructor
	public Student(){
		//인자가 없는 생성자 ; default constructor
	}
	// constructor overloading
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// field
	private String name;
	private int age;
	
	//getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// business method
	@Override
	public boolean equals(Object obj) {
		// equals method의 기능을 재 정의
		// 객체의 이름과 나이가 같으면 같다라고 새롭게 만들거예요.
		Student target = (Student) obj;
		boolean result = false;
		if ((this.name.equals(target.name)) &&
	// reference data type ; equals
				(this.age == target.age))	{
			// primitive data type ; ==    
			result = true;
		}
		return result;
	}
	@Override
	public String toString() {
		return this.name + "," +this.age;
	}
	
	
	
	
}

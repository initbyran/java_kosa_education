package com.uni;

public class Student extends Human {

	// 1. constructor
	public Student() {
	}

	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		
		this.number = number;
		this.major = major;
	}


	// 2. field
	private String number;
	private String major;
	
	
	// 3. method
	
	
	// getter & setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	//business method - overriding
	
	@Override
	public String printInformation() {
	// Human의 정보 + Student 특유의 정보
		return super.printInformation() + " " + number + " " + major;
	}
	

	

}

package com.uni;

public class Human {

	// 1. constructor
	public Human() {
	}
	
	// source - generate constructor using fields
	// 주석 처리 - ctrl+/
	
	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// 2. field
	private String name;
	private int age;
	private int height;
	private int weight;
	
	// 3. method
	
	// getter & setter
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	// business method
	
	public String printInformation() {
		return name + " " + age + " " + height + " " + weight ;
	}

}

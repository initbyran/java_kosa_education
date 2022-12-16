package javaexam2.student;

public class Student extends Human {

	public Student() {
		
	}
	
	private String number;
	private String major;
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age,height, weight);
		this.number=number;
		this.major=major;
	}
	
	public String printInformation() {
		return super.printInformation()+"\t"+number+"\t"+major;
}
}

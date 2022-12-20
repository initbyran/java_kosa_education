package javaexam2.company;

public class Sales extends Employee implements Bonus{

	public Sales() {
		
	}
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	
	}

	
	@Override
	public double tax() {
		
		return (double)(getSalary()*0.13);
	}

	@Override
	public void incentive(int pay) {
		setSalary((int)(getSalary()+(pay*1.2)));
		
	}

	
}

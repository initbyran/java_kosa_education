package mytest;

public class Department {

	// 1. constructor
    public Department() {	
    }
	public Department(String deptName, String deptNumber) {
		this.deptName = deptName;
		this.deptNumber = deptNumber;
	}
	
    // 2. field
	private String deptName; //학과명
	private String deptNumber; //학과전화번호
	

	// 3. method
    // business method
	// getter & setter
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
}

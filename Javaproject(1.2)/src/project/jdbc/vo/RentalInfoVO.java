package project.jdbc.vo;

public class RentalInfoVO {

	private String managerid;
	private String managerpw;
	
	public RentalInfoVO() {
	}

	public RentalInfoVO(String managerid, String managerpw) {
		super();
		this.managerid = managerid;
		this.managerpw = managerpw;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getManagerpw() {
		return managerpw;
	}

	public void setManagerpw(String managerpw) {
		this.managerpw = managerpw;
	}
	
	
}

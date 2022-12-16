package javaexam2.plane;

public abstract class Plane {

	public Plane() {
	}

	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	private String planeName;
	private int fuelSize;
	
	public abstract void flight(int distance);
	public abstract void refuel(int fuel);

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	
	
}

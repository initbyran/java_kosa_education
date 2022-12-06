package planetest;

public abstract class Plane {

	// 1. constructor
	public Plane () {
		
	}
	
	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}


	// 2. field
	private String planeName;
	private int fuelSize;

	
	// 3. method
	
	
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

	public void refuel (int fuel) {
		this.fuelSize += fuel;
	}
	
	@Override
	public String toString() {
	    return planeName + "      " + fuelSize;
	}
	
	public abstract void flight (int distance);
}

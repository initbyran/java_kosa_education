package javaexam2.plane;

public class Airplane extends Plane{

	public Airplane() {
		
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName,fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance/10)*30);
		
	}

	@Override
	public void refuel(int fuel) {
		setFuelSize(getFuelSize()+fuel);
		
	}

	
	}


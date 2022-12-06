package planetest;

public class Airplane extends Plane {

	
    // 1. constructor
    public Airplane(){
		
	}
    public Airplane (String planeName, int fuelsize) {
    	super(planeName, fuelsize);
    }
 
    
    // 2. field
    
	// 3. method
    @Override
	public void flight(int distance) {
		// 연료량은 운행거리 * 3 만큼 줄이면 돼요.
		setFuelSize(getFuelSize() - (distance*3));
	}
    
}

class Cargoplane extends Plane {

    // 1. constructor
	public Cargoplane () {
		super();
	}
	
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
    // 2. field

	// 3. method
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance*5));
		
	}


}
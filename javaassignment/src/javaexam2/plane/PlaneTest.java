package javaexam2.plane;


public class PlaneTest {

	public static void main(String[] args) {
		
		Plane air = new Airplane ("L747",1000);
		Plane cargo = new Cargoplane ("C40",1000);
		
	    System.out.println("Plane"+"\t\t"+"fuelSize");
	    System.out.println("----------------------------------");
	    System.out.println(air.getPlaneName()+"\t\t"+air.getFuelSize());
	    System.out.println(cargo.getPlaneName()+"\t\t"+cargo.getFuelSize());
        
	    System.out.println("");
	    
	    System.out.println("100운항");
        System.out.println("Plane"+"\t\t"+"fuelSize");
	    System.out.println("----------------------------------");
	    
	    air.flight(100);
	    cargo.flight(100);
	    
	    System.out.println(air.getPlaneName()+"\t\t"+air.getFuelSize());
	    System.out.println(cargo.getPlaneName()+"\t\t"+cargo.getFuelSize());
	    
	    System.out.println("");
	    
	    System.out.println("200주유");
	    System.out.println("Plane"+"\t\t"+"fuelSize");
	    System.out.println("----------------------------------");
	    
	    air.refuel(200);
	    cargo.refuel(200);
	    
	    System.out.println(air.getPlaneName()+"\t\t"+air.getFuelSize());
	    System.out.println(cargo.getPlaneName()+"\t\t"+cargo.getFuelSize());
	    
	}

}

package com.computer;

public class ComputerTest {

	public static void main(String[] args) {

//		Laptop과 tab은 둘 다 computer의 subclass -> IS-A 관계 ; computer의 arrays에 laptop, tab 저장 가능.

		Computer arrays[] = new Computer[4];

		arrays[0] = new Laptop("Lap01", 2, 1024, 2000);
		arrays[1] = new Laptop("Lap02", 3, 2048, 2300);
		arrays[2] = new Tab("Tab01", 2, 1024, 1200);
		arrays[3] = new Tab("Tab02", 3, 2048, 1300);
		
		System.out.println("name\tcpu\tmemory\tbattery");
		System.out.println("----------------------------------");
	
		// for 반복 구문
		for (Computer com : arrays) {
			System.out.println(com.toString());
			
		}
		
		
		System.out.println("\nname\tcpu\tmemory\tbattery\trendereing time");
		System.out.println("----------------------------------------------");
		
		
		for (Computer com : arrays) {
		    // 동적 바인딩 발생 
			com.operate(55);
			
			// if (com instanceof Laptop) { 
			// System.out.println( ((Laptop)com).redering(100)); -> laptop instance면 실행
			// } else { =
		    //  System.out.println (((Tab)com).redering(100));
			// }
			
			double render = com.rendering(100);
			System.out.println(com.toString()+"\t"+render);
		}
		
	}

}

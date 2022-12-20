package javaexam2.company;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
	
		HashMap<Integer,Employee> map = new HashMap<Integer,Employee>();
		
		map.put(1, new Secretary("Hilery",1,"secretary",800));
		map.put(2, new Sales("Clinten",2,"sales",1200));
		
		System.out.println("name"+"\t"+"department"+"\t"+"salary");
		System.out.println("------------------------------------------");
		
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}

		System.out.println("인센티브 100 지급");
		System.out.println("name"+"\t"+"department"+"\t"+"salary"+"\t"+"tax");
		System.out.println("-----------------------------------------------------");
		
		((Bonus)(map.get(1))).incentive(100);
		
		System.out.println(map.get(1) + "\t"+map.get(1).tax());
		
	}

}

package com.Test5;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		map.put(1,new Secretary ("Hilery",1,"Secretary",800));
		map.put(2,new Sales ("Clinten",2,"sales",1200));
	
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("--------------------------------");
		
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		
		System.out.println("인센티브 100 지급");
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("------------------------------------------");
		
		
		for (Integer i : map.keySet()) {
			((Bonus)(map.get(i))).incentive(100);
		}
	
		
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i) + "\t" + map.get(i).tax());
		}
		
	}

}

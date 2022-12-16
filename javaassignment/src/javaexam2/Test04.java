package javaexam2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {

		ArrayList <Integer> list = new ArrayList<Integer>();
	
		for(int i=0;i<10;i++) {
            int random = (int)(Math.random()*10+1);
            list.add(random);
		}
		for (Integer j: list) {
			System.out.print(j+" ");
		}
		
		Collections.sort(list);
		
		System.out.println("");
		
		for (Integer k: list) {
			System.out.print(k+" ");
		}
		
	}

}

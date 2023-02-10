package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam4673 {

	public static void main(String[] args) {

	
		ArrayList<Integer> numList = new ArrayList<>();
		
		for (int i = 1; i <= 10000; i++) {

			numList.add(i);
		}		 

		int selfNumber = 0;
		for (int n = 1; n < 100000; n++) {

			String strNum = Integer.toString(n);
			int[] arrNum = new int[strNum.length()];
			int sum = 0;
			for (int i = 0; i < strNum.length(); i++) {
				arrNum[i] = strNum.charAt(i) - '0';
				sum += arrNum[i];
			}

			selfNumber = n + sum;

			
            if (selfNumber <= 10000) {
				
				numList.remove((Integer)selfNumber);
				

			}

		}

		for (int k = 0; k < numList.size(); k++) {

			System.out.println(numList.get(k));
		}

	}

}

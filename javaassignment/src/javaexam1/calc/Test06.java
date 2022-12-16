package javaexam1.calc;

import java.lang.reflect.Array;

public class Test06 {

	public static void main(String[] args) {
	
      int [] array = {1,2,3,4,5,6,7,8,9,10};
      
      for (Integer i : array) {
    	  if(i%2==0) {
    		  continue;
       	  } System.out.println(i);
         
      }
      double sum = 0 ;
         
          for (int j=0; j<array.length;j++) {
        	  if(!(array[j]%2==0)) {
        		  sum += array[j];
        		  
        	  }      
          }
    System.out.println("합계 : "+sum);
	}

}

package assignment;

import java.util.Random;

public class Text04 {

	public static void main(String[] args) {

		int i;
		int j;
		int k;
  
  		for (i=1; i<7; i++) {
  			for (j=1; j<7; j++)	{
  				for (k=1; k<7; k++) {
  					if ((i*j*k)%3==0) {
  					System.out.println( i+"*"+j+"*"+k+"="+(i*j*k));
  					}
  				}
  			}
  		}
           
	}

}


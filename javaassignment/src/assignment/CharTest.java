package assignment;

import java.util.ArrayList;

public class CharTest {

	public static void main(String[] args) {
	 
		ArrayList <String> str = new ArrayList<String>();

		for(int i=0;i<args.length;i++) {
			str.add(args[i]);
	         
	} 
		
 StringBuffer sb = new StringBuffer();

		for(String str1 : str) {
			sb.append(str1);
					
		} for(int i = (sb.length()-1);i>=0;i--) {
			System.out.print(sb.charAt(i));
			} 

		}}

//public class Test08 {
//	   public static void main(String[] args) {
//	      int i=0;
//	      String newstr = "";
//	      while(i<args.length)
//	      {
//	         newstr +=args[i];
//	         i++;
//	      }
//	      newstr = newstr.toLowerCase();
//	      char[] arrch = newstr.toCharArray();
//	      for(int j = arrch.length-1; j>=0; j--)
//	      {
//	         System.out.print(arrch[j]);
//	      }
//	   }
//	}
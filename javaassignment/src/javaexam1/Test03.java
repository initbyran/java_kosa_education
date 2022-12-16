package javaexam1;

public class Test03 {

	public static void main(String[] args) {
		
		for(int j=2; j<6; j++) {
			for(int i=1; i<10; i++) {
				if(!(i%2==0) && !(j%2==0)) {
					System.out.println(j+"*"+i+"="+j*i);
				}
			}
		}

	}

}

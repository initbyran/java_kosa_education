package workshop02;

public class Test01 {

	public static void main(String[] args) {
		int x = 15;
		if (x>10 && x<20) {
			System.out.println("true");
		}
		char ch1 = ' ';
		if (!(ch1==' ' || ch1=='\t')) {
			System.out.println("true");
		}
		char ch2 = 'x';
		if (ch2 == 'X' || ch2 == 'x') {
			System.out.println("true");
		}
		char ch3 = '0';
		if (ch3>='0' && ch3<='9') {
			System.out.println("true");
		}
		char ch4 = 'a';
		if ((ch4>='a'&& ch4<='z')||(ch4>='A' && ch4<='Z')) {
			System.out.println("true");
		}
		int year = 400;
		if (year/400==0 || (year/4==0 && !(year/100==0))) {
			System.out.println("true");
		}
		boolean powerOn = false;
		if (!powerOn) {
			System.out.println("true");
		}
		String str = "yes";
		if (str.equals("yes")) {
			System.out.println("true");
		}
	}

}

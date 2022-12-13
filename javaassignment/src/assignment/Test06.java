package assignment;

public class Test06 {

	public static void main(String[] args) {
	
		 double a;
		 double b;
		 double c;
		 double d;
		 double e;
		 
	
		 
		 a = Double.parseDouble(args[0]);
		 b = Double.parseDouble(args[1]);
		 c = Double.parseDouble(args[2]);
		 d = Double.parseDouble(args[3]);
		 e = Double.parseDouble(args[4]);
		 
		 if (!(args.length == 5)) {
			 System.out.println("다시 입력하세요!");
		 }
		 
		 if (!(10 <= Integer.parseInt(args[]) <=99)) {
			 System.out.println("다시 입력하세요!");
		 }
		 
		 double f = (((a+b)/2)*0.6)+(((c+d)/2)*0.2)+(e*0.2);
		 
		 if (f>=90)  {
			 System.out.println("Gold Class");
		 } else if(f)
	}

}

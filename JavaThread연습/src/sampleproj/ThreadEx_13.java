package sampleproj;

class ThreadEx_13_1 implements Runnable {
	public ThreadEx_13_1 () {
	
	}
	
	
	@Override
	public void run() {
	   for (int i=0; i<6; i++ ) {
		   System.out.println(Thread.currentThread().getName());
	   }
	}

}

public class ThreadEx_13 {

	public static void main(String[] args) {
		Runnable r = new ThreadEx_13_1();
		Thread t = new Thread(r);
		
		ThreadEx_13_1 = new ThreadEx_13_1();
		
		t.start();
		
		
				
				
				
	}
}

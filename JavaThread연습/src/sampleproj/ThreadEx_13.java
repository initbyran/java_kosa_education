package sampleproj;

class Shared implements Runnable {
	public Shared () {
	
	}
	
	@Override
	public void run() {
	   
	   synchronized (this) {
	   for (int i=0; i<5; i++ ) {
		  
		   System.out.println(Thread.currentThread().getName());
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	}

}
}


public class ThreadEx_13 {

	public static void main(String[] args) {
	    
		Runnable r = new Shared();
	    
		Thread t1 = new Thread(r);
	    Thread t2 = new Thread(r);
	    
		t1.start();
		t2.start();
				
	}
}

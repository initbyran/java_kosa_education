package sampleproj;

class ThreadEx_03_1 extends Thread{
	
	public ThreadEx_03_1() {
		
	}
	
	public ThreadEx_03_1(String name) {
	    super(name);	
	}
	
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(this.getName());
		}
	}
}

public class ThreadEx_03 {  

	public static void main(String[] args) {
	
      Thread t1 = new ThreadEx_03_1("Thread-01");
      Thread t2 = new ThreadEx_03_1("Thread-02");
      
      //priority
      
      t1.setPriority(1);
      t2.setPriority(9);

	  t1.start();
	  t2.start();
	  
	}
}

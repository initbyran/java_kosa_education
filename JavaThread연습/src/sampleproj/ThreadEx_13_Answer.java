package sampleproj;

// 공유 객체를 생성하기위한 class
class Shared1 {
	// 공유 method
	public synchronized void printName() {
		
		try {
			for(int i=0; i<10; i++){
		       Thread.sleep(1000);
		       System.out.println(Thread.currentThread().getName());
		        
		       notify();
		       wait();
			   // 이미 block된 것을 notify시키고 wait로 들어가야함.
			}
		} catch (Exception e) {
		}
	}
}

class ThreadEx_13_1 implements Runnable {
	public ThreadEx_13_1 () {
		}
		
	public ThreadEx_13_1(Shared1 shared1) {
		super();
		this.shared1 = shared1;
	}

	// 공유 객체
	private Shared1 shared1;
	
	@Override
	public void run() {
		shared1.printName();
	}
}

public class ThreadEx_13_Answer {

	public static void main(String[] args) {
	  
		Shared1 shared1 = new Shared1();
	  // 공유객체로 runnable 객체 생성 -> runnable 객체로 Thread객체 생성
	  Thread t1 = new Thread(new ThreadEx_13_1(shared1),"첫번째 쓰레드");
	  Thread t2 = new Thread(new ThreadEx_13_1(shared1),"두번째 쓰레드");
	  
	  t1.start();
	  t2.start();
	}
}

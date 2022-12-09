package sampleproj;

// 공유 객체를 생성하기위한 class
class Shared {
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
		
	public ThreadEx_13_1(Shared shared) {
		super();
		this.shared = shared;
	}

	// 공유 객체
	private Shared shared;
	
	@Override
	public void run() {
		shared.printName();
	}
}

public class ThreadEx_13_Answer {

	public static void main(String[] args) {
	  
		Shared shared = new Shared();
	  // 공유객체로 runnable 객체 생성 -> runnable 객체로 Thread객체 생성
	  Thread t1 = new Thread(new ThreadEx_13_1(shared),"첫번째 쓰레드");
	  Thread t2 = new Thread(new ThreadEx_13_1(shared),"두번째 쓰레드");
	  
	  t1.start();
	  t2.start();
	}
}

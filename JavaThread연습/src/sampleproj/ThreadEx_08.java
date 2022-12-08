package sampleproj;


class ThreadEx_08_1 implements Runnable{
	// runnable이 field를 가지고 있으므로 thread를 따로따로 만들어줘야함
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
	    while (!stopped) {
	       // false였던 stopped가 true가 됨.
	       if(!suspended) {
	         System.out.println(Thread.currentThread().getName());
	try {
	Thread.sleep(1000);	
	} catch (Exception e) {
	}
		       }
		}
	
	}
	public void suspend () {suspended = true;}
	public void resume () {suspended = false;}
	public void stop () {stopped = true;}
	
}
public class ThreadEx_08 {

	public static void main(String[] args) {
     // Runnable instance를 공유하면 안됨. -> 서로 영향을 주지 않기 위해서 필드 공유 안함.
		
		ThreadEx_08_1 r1 = new ThreadEx_08_1();
		ThreadEx_08_1 r2 = new ThreadEx_08_1();
		ThreadEx_08_1 r3 = new ThreadEx_08_1();
	
	Thread t1 = new Thread(r1, "*");
	Thread t2 = new Thread(r2, "**");
	Thread t3 = new Thread(r3, "***");
	
	t1.start();
    t2.start();
    t3.start();
    
    try {
		Thread.sleep(2000); // main thread sleep
		//첫번째 thread 일시 정지
		r1.suspend(); // thread가 제어하는게 아님 -> thread가 가지고 있는 Runnable객체의 field값을 조절해서
		                // Runnable 객체가 가지고 있는 run() method의 로직을 변화시키는 것.
		Thread.sleep(2000);
		r2.suspend();
		Thread.sleep(2000);
		r1.resume();
		Thread.sleep(2000);
		r1.stop();
		r2.stop();
		Thread.sleep(2000);
		r3.stop();
		
		
	} catch (Exception e) {
	}
	
	}
	
}

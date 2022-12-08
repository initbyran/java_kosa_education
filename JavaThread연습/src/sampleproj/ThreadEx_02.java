package sampleproj;

class ThreadEx_02_1 extends Thread {
	
	public ThreadEx_02_1() {
	
	}
	
	public ThreadEx_02_1(String name) {
		super();
		this.setName(name); // thread 이름을 설정하는 method.
	
	}
	 
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(this.getName());
		}
	
	}
}
public class ThreadEx_02 {

	public static void main(String[] args) {
		Thread t1 = new ThreadEx_02_1 ("My-Thread");
		t1.run();
		System.out.println("main thread 종료!");
	}
}

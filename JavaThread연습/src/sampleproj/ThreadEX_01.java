package sampleproj;

 // import java.lang.* 자동으로 삽입

// 이 밑에 있는 class는 thread가 아님 -> Runnable이라는 특별한 interface가 구현한 class
class ThreadEX_01_2 implements Runnable {
  
	@Override
	public void run() {
	
		for (int i=0; i<5; i++) {
	    	System.out.println(Thread.currentThread().getName());
		
	}
}
}

// 이 밑에 있는 클래스는 Thread
class ThreadEX_01_1 extends Thread {
   
	public ThreadEX_01_1 () {
		
	}
	// 새로운 독립적인 실행 흐름.
	// 프로그램의 entry point에 준하는 무언가 시작 method가 있다는 의미.
	
	@Override  // thread의 method 재정의
	public void run() {
		// 내가 실행하고 싶은 code.
	    for (int i=0; i<5; i++) {
	    	System.out.println(this.getName());
	    }
	}
}

// java ThreadEX_01을 실행하면 JVM이 main method를 호출해서 프로그램을 시작.
// Thread 관점 : JVM이 내부적으로 Thread 하나 생성. -> main method 호출 ; main thread.
// process(프로그램)는 main method가 시작되면 시작, main method가 종료되면 종료 => 틀렸음!!
// process 안에 있는 모든 thread가 종료되어야 종료.

public class ThreadEX_01 {
	public static void main(String[] args) {
	// 하나의 thread에 의해서 실행되는 method.	
		  
		Runnable r2 = new ThreadEX_01_2(); 
	    Thread t2 = new Thread(r2);
	    
		ThreadEX_01_1 t1 = new ThreadEX_01_1();
		
		// t1은 Thread instance가 됨. -> 현재 객체일뿐
		// 이 thread는 독립적인 실행 흐름을 가지고 있어요. -> run()안에 그 내용 기술.
		// 이제 thread 실행
	//	t1.run();
		// 단순히 객체의 method를 호출하는거지 thread를 실행시킨게 아님.
		// 이렇게 하는게 아니라 다른 method를 사용해야함.
        t1.start();
        t2.start();
        // start를 이용해서 thread 실행.
		System.out.println("main thread 종료!");
	}
}

package sampleproj;

class ThreadEx_11_1 extends Thread {
	
	final static int MAX_MEMORY = 1000; // 최대값 설정
	// 상수 field는 일반적으로 대문자사용, snake case
	int usedMemory = 0 ; 
	
	@Override
	public void run() {
		
		while(true) { // 무한 루프
			try {
				Thread.sleep(10000); // 10초마다 메모리 감소
			} catch (Exception e) {
			}
			gc(); // memory 청소해서 memory 용량을 다시 확보하는 method
		System.out.println("남은 메모리량 : " + freeMemory());
		}
		}	
	   public void gc() {
		usedMemory -= 300;
		if (usedMemory<0) { // 예외사항에 대한 처리
			usedMemory = 0 ; // 초기화
		}
	   }
	   public int totalMemory() {
		   return MAX_MEMORY ;
	   }
	   public int freeMemory() { // 가용메모리
		   return MAX_MEMORY - usedMemory;
	   }
}
public class ThreadEx_11 { //main thread
     public static void main(String[] args) {
	//메모리를 사용하고 청소하는 로직을 작성
    	 ThreadEx_11_1 t = new ThreadEx_11_1();
    	 t.setDaemon(true); // main thread와 생명주기 공유.
         t.start();
         int requiredMemory = 0 ;
         
         for (int i = 0; i<20; i++) {
        	 requiredMemory = ((int)(Math.random() * 10))*20;  // 난수=랜덤값, 0<=난수<1, *10하면 0<=난수<10, int로 형변환 하면 정수값이 됨.
        	 // 0, 20, 40, 60, ... , 180
        	 
        	 // 위에서 구한 필요한 메모리량이 사용할 수 있는 메모리 량보다 크거나 
        	 // 전체 메모리의 60%이상을 사용했을때 GC를 깨울거예요.
        	 if((t.freeMemory() < requiredMemory) || t.freeMemory()< t.totalMemory()*0.4) {
        		 t.interrupt(); //main thread는 독립적으로 계속 돌기 때문에 예외가 생길수 있음.
        	     try {
					t.join(100); // 숫자를 안주면 무한 루프를 돌기 때문에 끝나지 않음.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // main thread holding
        	 }
        	 t.usedMemory += requiredMemory; // 사용된 메모리량을 누적.
        	 System.out.println("남은 메모리량 : " + t.freeMemory());
         }
}
}
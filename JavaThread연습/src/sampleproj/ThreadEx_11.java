package sampleproj;

class ThreadEx_11_1 extends Thread {
	
	final static int MAX_MEMORY = 1000; // 상수 field는 일반적으로 대문자사용, snake case
	int usedMemory = 0 ; 
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
			gc(); // memory 청소해서 memory 용량을 다시 확보하는 method
		System.out.println("남은 메모리량 :" + freeMemory());
		}
	
		}	
	   public void gc() {
		usedMemory = usedMemory- 300;
		if (usedMemory<0) {
			usedMemory = 0 ; // 초기화
		}
	   }
	   public int totalMemory() {
		   return MAX_MEMORY ;
	   }
	   public int freeMemory() {
		   return MAX_MEMORY - usedMemory;
	   }
}
public class ThreadEx_11 {
     public static void main(String[] args) {
	//메모리를 사용하고 청소하는 로직을 작성
    	 
}
}

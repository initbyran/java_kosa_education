package sampleproj;

public class ThreadEx_04 implements Runnable {

	static boolean autoSave = false;
	
	public static void main(String[] args) {
		
		Thread t = new Thread ( new ThreadEx_04());
		t.setDaemon(true);
        
		t.start();
     
	    for(int i=0; i<20; i++) {
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}	
		if (i==5) {
			autoSave = true;
			}
		}
	    }
	    	
	
	@Override
	public void run() {
	
	    while(true)	{
	    	//thread를 일정 시간동안 재울거예요.
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
			}
	    	if(autoSave) {
	    		System.out.println("자동저장되었어요!");
	    		
	    	}
	    }
	}
}

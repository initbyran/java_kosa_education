package sampleproj;

import javax.swing.JOptionPane;

class ThreadEx_06_1_part1 extends Thread{
	
	@Override
	public void run() {
             int i = 10 ;
             //while ()괄호 안이 true일동안 {}계속 반복
             while (i!=0 && !this.isInterrupted() ) {
            	 System.out.println(i--); // 10 출력 후 i 값을 1감소시킨다.
            	 try { Thread.sleep(2000); 
            	 } catch (InterruptedException e) {
            		
            		 this.interrupt();
				}
            	 
             }
             System.out.println("카운트가 종료되었습니다.!");
	}
}

public class ThreadEx_06_part1 {
public static void main(String[] args) {
		
		Thread t = new ThreadEx_06_1_part1(); // is-a relationship - thread instance 생성.
		
		t.start(); // Thread runnable 상태로 전이.
		           // 바로 실행되는 것은 아니나 thread scheduler에 의해 언젠가 실행될것.
		String data = JOptionPane.showInputDialog("값을 입력하세요!"); // blocking method
		System.out.println(data);
		
		//t.suspend(); //thread를 직관적으로 제어할 수 있으나 deprecated된 것.
	    t.interrupt();
}
}

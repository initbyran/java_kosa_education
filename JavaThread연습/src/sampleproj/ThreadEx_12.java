package sampleproj;

class Account  { // 일반 class의 일반 굥용 instance 생성
	
	public Account() {
 }
	
	public Account(int balance) {
	super();
	this.balance = balance;
}

	private int balance;
    // 동기화 method (synchronized method)
	// 이 method를 실행 Thread가 먼저 Lock(Monitor) 획득 -> 나머지 하나는 blocked.
	
//	public synchronized void withdraw(int money) {
//		// balance=300, thread01=200출금, thread02=200출금
//		// if 문을 동시에 통과하는 경우 잔액이 음수값이 되어버릴 수 있다.
//		if(balance >= money) {
//           try {
//        	   Thread.sleep(1000); // 1초 지나면 차감.
//           } catch (Exception e) {
//           }
//           balance -= money;
//		}
//	}
	
	public void withdraw(int money) {
		// balance=300, thread01=200출금, thread02=200출금
		// if 문을 동시에 통과하는 경우 잔액이 음수값이 되어버릴 수 있다.
	
		// synchronized block - critical section 임계 영역 
		synchronized (this) {
		
		if(balance >= money) {
           try {
        	   Thread.sleep(1000); // 1초 지나면 차감.
           } catch (Exception e) {
           }
           balance -= money;
		}
	}
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}	
}

class ThreadEx_12_1 implements Runnable {
	//field
	Account acc = new Account(1000);
	
	@Override
	public void run() {
		while(acc.getBalance() > 0 ) {
			int money=(int)(Math.random() *3 + 1)*100; // 100,200,300
					acc.withdraw(money); // 공용객체 출금처리
					System.out.println("남은 금액 : " + acc.getBalance());
		}
	}
	
}

public class ThreadEx_12 {
   
	public static void main(String[] args) {
		
		ThreadEx_12_1 r = new ThreadEx_12_1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r); // 경쟁적으로 출금. account 객체 공유.
		t1.start();
		t2.start();
		
	}
}

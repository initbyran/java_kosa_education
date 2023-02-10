package main;

import bank.*;

public class Main {

	// 1. 생성자
	// default 생성자가 들어와요.
	
	// 2. field도 존재할 수 있어요. 하지만 필요없죠.
	
	// 3. method는 entry point인 main method만 존재
	
	public static void main(String[] args) {
	
		// 1. 홍길동 instance를 생성해요
		//Customer hong = new Customer();
		
		// 2. 생성한 객체에 이름을 홍길동으로 setting
		//hong.name = "홍길동";
		
		Customer hong = new Customer("홍길동");
		
		// 3. 홍길동이 잔액을 확인해요
		long result = hong.getBalance();
	    System.out.println("잔액은 : " + result);
	   
	    // 4. 홍길동이 입금해요
	    hong.deposit(2000);
	    result = hong.getBalance();
	    System.out.println("잔액은 : " + result);
	    
	    // 5. 홍길동이 3000원 출금해요
	    long rest = hong.withdraw(3000);
	    System.out.println("잔액은 : " + rest);
        
	    // 6. 홍길동이 1000원 출금해요
	    rest = hong.withdraw(1000);
	    System.out.println("잔액은 : " + rest);
	}
}

package bank;

//연습
//은행고객(customer)에 대해 class와 instance를 이용해 다음의 내용을 구현.
//은행고객 정보 : 이름, 계좌번호, 잔액
//기능 : 입금한다, 출금한다, 잔액확인한다

//1. 홍길동 잔액 확인 = 0
//2. 입금 = 2000
//3. 출금 = 3000 (실패)
//4. 출금 = 1000
//5. 잔액 확인 = 1000

public class Customer {

	//1. 생성자 정의
	// 생성자가 같은 package 안에 있는 다른 class에 의해서 사용된다면 public keyword가 필요없어요.
	// 만약 생성자가 다른 package 안에 있는 다른 class에 의해서 사용된다면 public keyword가 필요해요.(다른 사람으로부터 전달받아 재활용해서 사용할때)
	// class의 용도에 따라 public 인지 아닌지 결정.
	// 같은 project 내에서도 다른 package라면 public keyword 필요.
	// 우리는 같은 프로젝트안에서 다른 패키지에서 커스투머 클래스의 인스턴스를 생성 -> public 생성자에 붙여야함
	public Customer() {
         // default 생성자 : parameter도 받지 않고 하는 일도 없는 생성자
		 // 생성자 작성 안하면 자동적으로 삽입
		 // data type이 들어가면 method가 되어버림
		 // 리턴타입 없음
	}
	// 그런데 생성자는 1개 애상 있을 수 있어요
	// 하나의 클래스 안의 생성자의 이름은 모두 동일하기 때문에 인자의 개수 혹은 인자의 타입으로 생성자 구분
	// 생성자는 만들어진 인스턴스의 초기화를 담당 ; 인스턴스의 필드초기값을 설정하는 일
	// 여러가지 인스턴스 값 초기화를 위해 여러개의 생성자를 사용
	public Customer(String name) {
		this.name = name;
	}
	
	// 2. field 선언 
    public String name; // 고객이름 -> instance variable
    public String accountNumber; // 계좌번호 -> instance variable
    public long balance; // 잔액 -> instance variable
    
    // 3. method 정의
    // 잔액을 확인한다 라는 기능
    // 기능 자체가 잔액을 조사해서 출력까지 진행할건지, 기능은 잔액을 조사해서 잔액의 값만 리턴시키고 출력은 따로 수행할건지.
    public long getBalance() {
      return this.balance;
      // this는 변수 - instance에 대한 reference 주소가 들어있다, 현재 사용하는 객체에 대한 주소
    }   
    // 입금하는 기능 (리턴값이 없는 형태의 method)
    public void deposit(long money) {
      this.balance += money; // this.balance = this.balance + money; 
    }
    
    // 출금하는 기능(출금 후 잔액을 리턴값으로 사용)
    public long withdraw(long money) {
        // 만약 잔액이 출금요정액보다 적으면 출금이 되면 안된다.
        if(this.balance < money) {
        	System.out.println("돈이 없어요. 확인해주세요!");
    
       } else { 
	        this.balance -= money;
}
return this. balance; 
}
	
}

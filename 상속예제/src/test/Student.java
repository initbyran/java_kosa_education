package test;

// java test.Student => JVM을 통해 실행 => main 호출

// 객체지향의 상속을 이용해서 class를 다시 만들어보아요.
// java에서  extends라는 keyword를 제공해요.
// extends 뒤에 class가 나올 수 있는데 java는 이때 단 하나의 class만 나올 수 있어요.(다중상속X) ; 단일상속
// 생성자는 써야하고 field, method는 그대로 포함됨.

public class Student extends Person {

	// 1. constructor
	public Student() {
		// super("홍길동"); // 무조건 이걸로 시작 ; 만약 없으면 자동으로 삽입.
		         // person()이 호출되어서 실행.
		//default constructor
		//상위 클래스의 constructor 호출하는 부분
		
		//현재 객체의 field를 초기화하는 부분
	}
	
	// 2. field
	private String dept; 
	
	// 3. method
	// 상속 받은 상위 클래스의 메소드를 하위클래스에서 다시 정의 해요 ; method overriding (메소드 오버라이딩)
	public void eat() {
		super.eat(); //overriding되어 숨겨져 있는 상위의 method호출 가능.
		System.out.println("밥을 신나게 먹어요");
	}
    public void study() {
    	System.out.println("공부를 해요!");
	}
    
    // entry point
    public static void main(String[] args) {
    	Person s = new Student(); // Sub class is a Super class (Student is a Person) ; 역은 성립하지 않는다.
        // s.eat(); // 사용 가능
        // s.study(); //사용불가 -> 형(type)변환을 이용하면 돼요! ; casting 작업을 하면 돼요 - ()괄호 이용
        // ((Student)s).study(); -> method overriding
    	
        s.eat(); // 동적 바인딩 (dynamic binding)
        // 원래는 Person의 eat() method를 호출해야하는데 
        // 해당 객체가 method overriding을 이용해 메소드를 다시 작성한 경우
        // overriding된 method를 대신 호출.
        // 결국, person에 있는 eat()은 호출할 방법이 없다.
        
    }
}

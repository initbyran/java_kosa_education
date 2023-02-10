package bpackage;

class CClass {

	//constructor
	
	//field
	
	//method
	
     public static void main(String[] args) {
      BClass b = new BClass();
      b.bField = 100; //private ; 접근불가 -> 그럼 어떻게?
      b.setbField(100); // setter를 이용해서 값을 바꿔야해요.
}
}
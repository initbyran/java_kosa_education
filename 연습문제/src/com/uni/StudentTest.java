package com.uni;

public class StudentTest {

	// 배열을 만들때는 new 다음에 data type이 온다
	
	public static void main(String[] args) {
		

		Student arrays [] = new Student[3];
		
		//데이터 입력
	    arrays[0] = new Student ("홍길동", 15, 171, 81, "201101", "영문");
	    arrays[1] = new Student ("한사람", 13, 183, 72, "201101", "건축"); 
	    arrays[2] = new Student ("임걱정", 16, 175, 65, "201103", "무영");
	   
        //출력
	    // 집합자료형 : 배열과 같이 여러개의 데이터를 한꺼번에 저장하고 있는 객체
	    for( Student s : arrays ) {
	    	System.out.println(s.printInformation());
	    }

}
}
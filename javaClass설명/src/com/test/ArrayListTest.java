package com.test;

import java.util.ArrayList;

// import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList 하나 생성해보아요.
     	ArrayList<Object> a = new ArrayList<Object>();
        a.add("Hello");
        a.add(new Student ("홍길동",20));     	
        //a.add(new Integer(100));
	    a.add(100); // Auto Boxing 발생하고 사용하는 class는 Integer
	    a.add(3.14); // Auto Boxing 발생하고 사용하는 class는 double
	    // 노란 밑줄 ; warning
	    
	    ArrayList<String> b = new ArrayList<String>();
	    b.add("Hello");
	    b.add("홍길동");
	    b.add(new String("소리없는 아우성!"));
	    //b.add(100); -> code error
	    
	}
	
	
	
}

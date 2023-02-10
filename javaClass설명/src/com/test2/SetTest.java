package com.test2;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
      
		HashSet<String> set = new HashSet<String>();
		
		// 데이터 저장
		set.add("123");
		set.add("홍길동");
		set.add("신사임당");
		
		// 데이터 추출
	    for (String s : set) {
	    	System.out.println(s);
	    }

	}

}

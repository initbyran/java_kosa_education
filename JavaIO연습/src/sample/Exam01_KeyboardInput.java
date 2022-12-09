package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01_KeyboardInput {

	public static void main(String[] args) {
		
		System.out.println("키보드로 한줄을 입력하세요!");
		
		// 키보드로부터 입력을 받으려면 데이터 연결 통로(stream)이 있어야함
		// System.in ; InputStream class instance -> 불편
		// 문자기반의 데이터 받기를 원하니 Reader를 하나 만들어야해요.
		// new InputStreamReader(System.in) 이렇게 stream을 결합해서 문자 기반의 통로를 열었어요 -> 불편
		// 조금 더 편한 문자 기반의 데이터 입력 연결 통로는 만들어볼거예요.
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
       
		try {
        	String s = br.readLine();
        	System.out.println("입력받은 데이터는 : " + s);
        } catch (IOException e) {
        	
        }
 	}

}

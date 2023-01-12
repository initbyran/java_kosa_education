package example.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {

	public static void main(String[] args) {
		// 도서 조회, 삭제 ; 데이터베이스 처리를 MyBatis를 이용해서 해보기
		// 간단하게 DAO만 작성 (Controller, Service 배제)
		
		// 1.책의 isbn을 이용해서 책 1권의 데이터 출력 ; HashMap 사용
		// 기존에는 DAO한테 connection넘겨줌.
		// -> MyBatis ; DAO에게 SqlSessionFactory를 넘겨줌(static method 호출)
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory); // injection
		
//		HashMap<String,Object> map = dao.selectByISBNHashMap("89-7914-206-4");
//		
//		for(String key : map.keySet()) {
//			System.out.println(key + ", "+map.get(key));
//		}

		// 2. 조건없이 모든 책의 데이터 출력
//		List <HashMap<String, Object>> list = dao.selectAllHashMap();
//		for(HashMap<String,Object> map : list) {
//			for(String key : map.keySet()) {
//				System.out.println(key + ", "+map.get(key));
//			}
//		}
		
		// 3. 책의 isbn을 이용해서 책 1권의 데이터 출력 ; VO 활용
//		BookVO book = dao.selectByISBNBookVO("89-7914-206-4");
//		System.out.println(book.getBtitle() + ", "+book.getBauthor());
		
		// 4. 책의 isbn을 이용해서 책 1권의 데이터 출력 ; resultmap 활용
//		BookVO book = dao.selectByISBNResultMap("89-7914-206-4");
		
		// 5. 책의 isbn을 이용해서 책 1권의 데이터 수정
		// update는 결과값이 integer
		BookVO book = new BookVO();
		book.setBisbn("89-7914-206-4");
		book.setBtitle("자바30일완성!!");
		book.setBisbn("신사임당");
		book.setBprice(3000);
		int result = dao.updateByISBN(book); // data를 주고받을때는 가능한한 VO활용
		
		System.out.println("영향을 받은 행의 수 : "+result);
	}

}

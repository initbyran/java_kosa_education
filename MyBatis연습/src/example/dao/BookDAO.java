package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {

	private SqlSessionFactory factory;
	
	public BookDAO(SqlSessionFactory factory) {
		// 생성자 주입
		this.factory = factory;
		// factory를 인자로 받아 현재 class에 field값 주입.
	
		
	}

	public HashMap<String, Object> selectByISBNHashMap(String isbn){
		HashMap<String, Object> map = null;
		SqlSession session = factory.openSession();
		map = session.selectOne("example.myBook.selectBookByISBNHashMap", isbn); // 원래 가지고 있는 method
		
		return map;
	}

	public List<HashMap<String, Object>> selectAllHashMap() {
		SqlSession session = factory.openSession();
		List<HashMap<String, Object>> list =null;
	    list = session.selectList("example.myBook.selectAllHashMap");
		return list;
	}

	public BookVO selectByISBNBookVO(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		book = session.selectOne("example.myBook.selectBookByISBNBookVO",isbn);
		return book;
	}

	public BookVO selectByISBNResultMap(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		try {
		book = session.selectOne("example.myBook.selectBookByISBNResultMap",isbn);
		} 
		finally { session.close();
		}
		return book;
	}

	public int updateByISBN(BookVO book) {
		int result =0;
		SqlSession session = factory.openSession();
		try {
		result = session.update("example.myBook.update",book);
		} catch (Exception e) {
	   
		} finally {
			session.commit();
			session.close();
		}
	
		return result;
	}


}

package lecture.jdbc.service;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.vo.BookVO;

// service : business logic 담당 - method 계속해서 추가
public class BookService {

	public ObservableList<BookVO> selectBooksByKeyword(String text) {
	    // keyword를 받아서 list return하는 transaction 처리
		// 이 작업을 하기 위해서 로직 처리 + 데이터베이스 처리 필요
		// (이번 케이스는 로직 처리 필요없으므로 생략 - 단순 데이터베이스 검색)
		// -> DAO에게 데이터베이스 처리(CRUD) 시킴(Data Access Object)
		BookDAO dao = new BookDAO();
		// CRUD 이므로 method는 select,update,delete,insert 등...
		ObservableList<BookVO> list = dao.select(text);
		return list;
	}

	public ObservableList<BookVO> deleteByISBN(String deleteISBN, String searchKeyword) {
		// DB 처리
		BookDAO dao = new BookDAO();
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list = dao.select(searchKeyword);
		
		return list;
	}

	public ObservableList<BookVO> doubleClickDialog (String clickedRowData) {
		// DB 처리
		
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> list = dao.doubleClick(clickedRowData);
		
		return list;
		
		
	}
	
}

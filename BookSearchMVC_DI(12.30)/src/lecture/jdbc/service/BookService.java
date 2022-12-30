package lecture.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.dao.DBCPConnectionPool;
import lecture.jdbc.vo.BookVO;

// service : business logic 담당 - method 계속해서 추가
public class BookService {

	public ObservableList<BookVO> selectBooksByKeyword(String text) {
	    // keyword를 받아서 list return하는 transaction 처리
		// 이 작업을 하기 위해서 로직 처리 + 데이터베이스 처리 필요
		// (이번 케이스는 로직 처리 필요없으므로 생략 - 단순 데이터베이스 검색)
		// -> DAO에게 데이터베이스 처리(CRUD) 시킴(Data Access Object)	
		Connection con = null;
		try {
		     con = (DBCPConnectionPool.getDataSource()).getConnection();
		     con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		// CRUD 이므로 method는 select,update,delete,insert 등...
		ObservableList<BookVO> list = dao.selectAll(text);
		return list;
	}
	
	public ObservableList<BookVO> doubleClickDialog (String clickedRowData) {
		// DB 처리
		Connection con = null;
		try {
		     con = (DBCPConnectionPool.getDataSource()).getConnection();
		     con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		
		ObservableList<BookVO> list = dao.select(clickedRowData);
		return list;	
	}
	
	public ObservableList<BookVO> deleteByISBN(String deleteISBN, String searchKeyword) {
		// DB 처리
		// transaction start.
		// 지금은 connection pool에서 독립적인 connection을 빌려오고 반납하며 사용 중.
		// Connection : setAutocommit(false) 
		// connection으로 transaction을 걸어주면 transaction을 유지하기 어려움.
		// 단일 connection에 transaction을 걸어줘야하므로 DI를 활용.
		// 1. connection class 별도로 작성
		// 2. connection 얻어오기
		// 3. 하나의 transaction 유지
		Connection con = null;
		try {
		     con = (DBCPConnectionPool.getDataSource()).getConnection();
		     con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list = dao.selectAll(searchKeyword);
		// transaction end.
		// service method success -> transaction commit
		// service method fail -> transaction rollback
		if (count==1 && list !=null) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	
}

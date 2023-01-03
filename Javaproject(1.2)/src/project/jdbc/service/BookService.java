package project.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import project.jdbc.dao.BookDAO;
import project.jdbc.dao.DBCPConnectionPool;
import project.jdbc.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> selectBookByKeyword(String text){
		Connection con = null;
		try {
		      con = (DBCPConnectionPool.getDataSource()).getConnection();
		      con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.selectAll(text);
		
		return list;
	}

	public BookVO selectDetailsByKeyword(String bisbn) {
		Connection con = null;
		try {
		      con = (DBCPConnectionPool.getDataSource()).getConnection();
		      con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		BookDAO dao = new BookDAO(con);
		BookVO book = dao.select(bisbn);
		
 		return book;
	}

	public ObservableList<BookVO> deleteByISBN(String deleteISBN, String searchKeyword) {
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
		if(count == 1 && list != null) {
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

package project.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javafx.collections.ObservableList;
import project.jdbc.dao.BookDAO;
import project.jdbc.dao.DBCPConnectionPool;
import project.jdbc.dao.MembershipDAO;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;

public class BookService {

	public ObservableList<BookVO> selectBookByKeyword(String text){
		Connection con = null;
		try {
		      con = (DBCPConnectionPool.getDataSource()).getConnection();
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.selectAll(text);
		
		return list;
	}

	public ObservableList<BookVO> selectBookrental(String loginId) {
		Connection con = null;
		try {
		      con = (DBCPConnectionPool.getDataSource()).getConnection();
		  
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.selectAllBookRental(loginId);
		return list;
	}
	public BookVO selectDetailsByKeyword(String bisbn) {
		Connection con = null;
		try {
		      con = (DBCPConnectionPool.getDataSource()).getConnection();
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		BookVO book = dao.select(bisbn);
		
 		return book;
	}
	public ObservableList<BookVO> deleteByRisbn(String risbn, String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		
		int count = dao.deleteR(risbn);
		if(count==1)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ObservableList<BookVO> list = dao.selectAllBookRental(loginId);
		return list;
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

	public void insertBook(String isbn, String title, String author, String publisher, String date, int page,
			String translator) {

		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		dao.insertAll(isbn,title,author,publisher,date,page,translator);
		
	}

	public void insertRentalInfo(String isbn, String title, String author, String publisher, String id, Date date,
			Date duedate) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		dao.insert(isbn,title,author,publisher,id,date,duedate);
		
	}

	public ObservableList<BookVO> updateByISBN(String borrowedISBN, String searchKeyword) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		dao.update(borrowedISBN,searchKeyword);
		ObservableList<BookVO> list = dao.selectAll(searchKeyword);
	
		return list;
	}

//	public ObservableList<BookVO> updateByRisbn(String risbn) {
//		
//		Connection con = null;
//		try {
//			con = (DBCPConnectionPool.getDataSource()).getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO dao = new BookDAO(con);
//		dao.updateReturn(risbn);
//		ObservableList<BookVO> list = dao.selectAll(risbn);
//	
//		return list;
//	}

	public void updateBookInfo(String isbn, String title, String author, String publisher, String date, int page,
			String translator, String updateISBN) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		
		int count = dao.updateB(isbn,title,author,publisher,date,page,publisher,updateISBN);
	}

	public BookVO selectB(String updateISBN) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    BookVO book = new BookVO();
		BookDAO dao = new BookDAO(con);
		book = dao.selectOne(updateISBN);
		return book;
	}

	public BookVO selectDate(String risbn) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    BookVO book = new BookVO();
		BookDAO dao = new BookDAO(con);
		book = dao.selectD(risbn);
		return book;
	}

	public BookVO selectOverdueBook() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		BookVO book = dao.selectOverdue();
	
		return book; 
		}

	public ObservableList<BookVO> selectOverdueBookList() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
	
		ObservableList<BookVO> list = dao.selectO();
	
		return list;
	}

	public BookVO selectBorrowed(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BookVO book = new BookVO();
		BookDAO dao = new BookDAO(con);
		book = dao.selectB(loginId);
		return book;
	}

}

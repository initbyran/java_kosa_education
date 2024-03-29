package project.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;

public class BookDAO {

	Connection con = null;
	
	public BookDAO() {
	}

	public BookDAO(Connection con) {
		super();
		this.con = con;
	}
	
	private SqlSessionFactory factory;
	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}
	
	
	public List<BookVO> selectAll(String text){
		
		List<BookVO> list = null;
		SqlSession session = factory.openSession();
		try{
			list = session.selectList("project.myBook.selectBook",text);
		} finally { 
			session.close(); 
		}
		return list;
	}
	
	public ObservableList<BookVO> selectAllBookRental(String loginId) {
		ObservableList<BookVO> list = null;
		
		String sql = "SELECT risbn, rtitle, rauthor, rpublisher, rduedate FROM bookrental WHERE rid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("risbn"),rs.getString("rtitle"),rs.getString("rauthor"),rs.getString("rpublisher"),rs.getDate("rduedate"));
	            list.add(book);
			}   rs.close();
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public BookVO select(String bisbn){

		BookVO book = null;
		
    	String sql = "SELECT bdate,bpage,btranslator FROM book WHERE bisbn = ?";
		
		try {	
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bisbn);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = new BookVO(rs.getString("bdate"),rs.getInt("bpage"),rs.getString("btranslator"));
			book.setBdate(rs.getString("bdate"));
			book.setBpage(rs.getInt("bpage"));
			book.setBtranslator(rs.getString("btranslator"));
		} 
	
		rs.close();
		pstmt.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return book;
	}


	public int delete(String deleteISBN) {
		
		int count = 0;
		SqlSession session = factory.openSession();
		try {
			
		count = session.delete("project.myBook.delete",deleteISBN);
		if(count ==1) {
			session.commit();
		}
		} catch (Exception e) {
			System.out.println("ok");
		} finally {
			session.close();
		}
		
		return count;
	}

	public int deleteR(String risbn) {
		String sql = "DELETE FROM bookrental WHERE risbn = ?";
		int count = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, risbn);
			
			count = pstmt.executeUpdate();
		
			pstmt.close();
			
		} catch (Exception e1) {
		
		}
		
		return count;
	}

	public void insertAll(String isbn, String title,  String author, 
			String publisher, String date, int page, String translator) {
	
		String sql = "INSERT INTO book VALUES (?,?,?,?,null,?,?,null,?,null,null,'대여가능')";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, date);
			pstmt.setInt(4, page);
			pstmt.setString(5, author);
			pstmt.setString(6, translator);
			pstmt.setString(7, publisher);
			
			int Count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insert(String isbn, String title,  String author, 
			String publisher, String id, Date date, Date duedate) {
	
		String sql = "INSERT INTO bookrental VALUES (?,?,?,?,?,?,?,null)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setString(5, id);
			pstmt.setDate(6, (java.sql.Date)date);
			pstmt.setDate(7, (java.sql.Date)duedate);
			
			int Count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void update(String borrowedISBN, String searchKeyword) {
		SqlSession session = factory.openSession();
		session.selectOne("project.myBook.update",borrowedISBN);
	
	}

	public void updateReturn(String risbn) {
		String sql = "UPDATE book SET bborrowable = '대여가능' WHERE bisbn = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, risbn);
			
			int Count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public int updateB(String isbn, String title, String author, String publisher, String date, int page,
			String translator, String updateISBN) {
		String sql = "UPDATE book SET bisbn=?, btitle=?, bauthor=?, bpublisher=?, bdate=?, bpage=?, btranslator=? WHERE bisbn = ?";
		int count=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setString(5, date);
			pstmt.setInt(6, page);
			pstmt.setString(7, translator);
			pstmt.setString(8, updateISBN);
		
			int Count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public BookVO selectOne(String updateISBN) {
		BookVO book = null;
		String sql = "SELECT * FROM book WHERE bisbn=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateISBN);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getString("bpublisher"),rs.getString("bdate"),rs.getInt("bpage"),rs.getString("btranslator"));
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
		} 
		return book;
	}

	public BookVO selectD(String risbn) {
		BookVO book = null;
		String sql = "SELECT rduedate FROM bookrental WHERE risbn=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, risbn);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new BookVO((java.util.Date)rs.getDate("rduedate"));
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
		} 
		return book;
	}

	public BookVO selectOverdue() {
		BookVO book = null;
		String sql = "SELECT * FROM bookrental WHERE DATEDIFF(rduedate, curdate()) < 0 ;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				book = new BookVO(rs.getString("risbn"),rs.getString("rtitle"),rs.getString("rauthor"),rs.getString("rpublisher"),rs.getString("rid"),rs.getDate("rdate"),rs.getDate("rduedate"),rs.getString("roverdue"));
	    
			}   rs.close();
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public ObservableList<BookVO> selectO() {
		ObservableList<BookVO> list = null;
		String sql = "SELECT * FROM bookrental WHERE DATEDIFF(rduedate, curdate()) < 0 ;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("risbn"),rs.getString("rtitle"),rs.getString("rauthor"),rs.getString("rpublisher"),rs.getString("rid"),rs.getDate("rdate"),rs.getDate("rduedate"),rs.getString("roverdue"));
	            list.add(book);
			}   rs.close();
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BookVO selectB(String loginId) {

		BookVO book=null;
		
		String sql = "SELECT rtitle FROM bookrental WHERE rid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new BookVO(rs.getString("rtitle"));
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
		} return book;
	}
}

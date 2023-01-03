package project.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.jdbc.vo.BookVO;

public class BookDAO {

	Connection con = null;
	
	public BookDAO() {
	}

	public BookDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public ObservableList<BookVO> selectAll(String text){
		ObservableList<BookVO> list = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bpublisher ");
		sql.append("FROM book ");
		sql.append("WHERE btitle like ? ");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+text+"%");
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getString("bpublisher"));
	            list.add(book);
			}
			rs.close();
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
		
		String sql = "DELETE FROM book WHERE bisbn = ?";
		int count = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteISBN);
			
			count = pstmt.executeUpdate();
		
			pstmt.close();
			
		} catch (Exception e1) {
		
		}
		
		return count;
	}
}

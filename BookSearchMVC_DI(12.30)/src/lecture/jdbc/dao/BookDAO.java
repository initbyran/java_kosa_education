package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookVO;

// DAO : database 처리(CRUD)
public class BookDAO {
	
	Connection con = null;
	
	public BookDAO() {
	}
	
	public BookDAO(Connection con){ 
		super();
		this.con = con;
	}
	
	public ObservableList<BookVO> selectAll(String text) {
		
		ObservableList<BookVO> list = null;
		
    	StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		sql.append("FROM book ");
		sql.append("WHERE btitle like ? ");
		sql.append("ORDER BY bprice DESC");
		
		try {	
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, "%"+text+"%");
		
		ResultSet rs = pstmt.executeQuery();
		
		list = FXCollections.observableArrayList();
		
		while(rs.next()) {
			BookVO book = new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getInt("bprice"));
	        list.add(book);
		} 
		
		rs.close();
		pstmt.close();
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list; // -> controller -> view
	}

	public int delete(String deleteISBN) {
		
		
		String sql = "DELETE FROM book WHERE bisbn = ?";
		
		int count = 0;
		
		try {
			con.setAutoCommit(false); // transaction
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteISBN);
			count = pstmt.executeUpdate();
					
			pstmt.close();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return count;
	}

	public ObservableList<BookVO> select(String clickedRowData){

		ObservableList<BookVO> list = null;
		
    	String sql = "SELECT bdate,bpage,bsupplement,bpublisher FROM book WHERE bisbn = ?";
		
		try {	
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, clickedRowData);
		
		ResultSet rs = pstmt.executeQuery();
		
		list = FXCollections.observableArrayList();
		
		while(rs.next()) {
			BookVO book = new BookVO(rs.getString("bdate"),rs.getInt("bpage"),rs.getString("bsupplement"),rs.getString("bpublisher"));
	        list.add(book);
		} 
		
		rs.close();
		pstmt.close();
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list; // -> controller -> view
	}
	}
	


package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookVO;

// DAO : database 처리(CRUD)
public class BookDAO {
	
	private static BasicDataSource basicDS;
	static {
		// connection pool
		basicDS = new BasicDataSource();
		// Driver loading & connection
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("test1234");
		basicDS.setInitialSize(10); // connection 초기개수
		basicDS.setMaxTotal(20); // connection 최대개수
	}
	
	public static DataSource getDataSource() {
		// basic data source의 상위 type : data source(interface)
		// basic data source를 외부에서도 사용할 수 있게 해줌.
		// is-A 관계
		return basicDS;
	}
	
	public ObservableList<BookVO> select(String text) {
		
		DataSource ds = getDataSource();
		
		ObservableList<BookVO> list = null;
		
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
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
		con.close();
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list; // -> controller -> view
	}

	public int delete(String deleteISBN) {
		
		DataSource ds = getDataSource();
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		String sql = "DELETE FROM book WHERE bisbn = ?";
		
		try {
			con.setAutoCommit(false); // transaction
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteISBN);
			int count = pstmt.executeUpdate();
			
			// transaction ; 결과 처리
			if (count == 1) {
				con.commit();
				// 자동으로 refresh
		        // code의 중복 방지 (유지보수성)		
				
			} else {
				con.rollback();
			}
			
			pstmt.close();
			con.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return 0;
	}

	public ObservableList<BookVO> doubleClick (String clickedRowData){


    	DataSource ds = getDataSource();
		
		ObservableList<BookVO> list = null;
		
		Connection con = null;
		
		try {
			con = ds.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
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
		con.close();
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list; // -> controller -> view
	}
	}
	


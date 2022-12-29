package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
 
	private static BasicDataSource basicDS;
	
	// main이 호출되기 전에 특정 코드 먼저 실행
	// 일반적으로 프로그램에서 사용하는 resource같은거 로딩할때 사용
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
		// is-A 관계
		return basicDS;
	}
	
	public static void main(String[] args) {

		DataSource ds = getDataSource();
		Connection con = null;
		try {
			// connection pool에서 대여
			con = ds.getConnection();
			
			String sql = "SELECT btitle, bauthor FROM book";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("btitle"));
			}
			rs.close();
			pstmt.close();
			con.close(); // pool에 반납
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}

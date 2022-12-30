package lecture.jdbc.di.step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	// 연결정보를 가지고 connection 생성하는 method 작성
	public Connection getConnection() {
		
        Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			
			con = DriverManager.getConnection(jdbc_url,id,pw);
			      
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} return con;
	}
	
}

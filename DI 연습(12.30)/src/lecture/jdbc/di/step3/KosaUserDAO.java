package lecture.jdbc.di.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 만약 KosaUserDAO가 또 다른 클래스를 상속해야한다면?
// java는 단일 상속만 지원 -> 문제발생!

public class KosaUserDAO extends UserDAO {

	@Override
	protected Connection getConnection() {
	
		// 구매자가 자신의 데이터베이스 코드를 넣어주면 돼요
		// connection return code.
		
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

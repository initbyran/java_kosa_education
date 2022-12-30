package lecture.jdbc.di.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

// DAO = data access object
// DAO 안에는 Business Logic이 나올 수 없어요. ; database 처리
// VO(data주고받음)가 DAO로 전달되서 처리		
	public void insert(User user) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql = "INSERT INTO users VALUES (?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3,user.getPassword());
			
	        int count = pstmt.executeUpdate();
			
	        pstmt.close();
	        con.close();
	        
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public User select(String string)  {
		
		User user = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql = "SELECT * FROM users WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, string);
			
	        ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			user = new User(string, rs.getString("name"), rs.getString("password"));
			
	        pstmt.close();
	        con.close();
			
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		
		return user;
	}

}

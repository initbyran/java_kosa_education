package lecture.jdbc.di.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
//return type : connection
//DAO 내부에서만 쓸 공통 method이므로 private	
	private Connection getConnection() {
	
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
	
public void insert(User user) {
		
		try {
			Connection con = getConnection();
			
			String sql = "INSERT INTO users VALUES (?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3,user.getPassword());
			
	        int count = pstmt.executeUpdate();
			
	        pstmt.close();
	        con.close();
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public User select(String string)  {
		
		User user = null;
		try {
			Connection con = getConnection();
			
			String sql = "SELECT * FROM users WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, string);
			
	        ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			user = new User(string, rs.getString("name"), rs.getString("password"));
			
	        pstmt.close();
	        con.close();
			
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		
		return user;
	}

	
}

package lecture.jdbc.di.step4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//단일 상속으로 생기는 제한 문제 해결방법?
//연결정보를 class단위로 분리

public class UserDAO {


	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDAO() {
	
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
		
		public void insert(User user) {
			
			try {
				Connection con =simpleConnectionMaker.getConnection();
				
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
				Connection con = simpleConnectionMaker.getConnection();
				
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
	


package project.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;

public class MembershipDAO {

	Connection con;
	
	public MembershipDAO() {
	}

	public MembershipDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public MembershipVO select(String loginId, String loginpw) {
		
		MembershipVO membership=null;
		
		String sql = "SELECT mid, mpw FROM membership WHERE mid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				membership = new MembershipVO(rs.getString("mid"),rs.getString("mpw"));
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
		} return membership;
		
	}
	
	public RentalInfoVO selectmanager(String managerId) {
		
		RentalInfoVO manager = null;
		String sql = "SELECT managerid, managerpw FROM manager WHERE managerid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, managerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				manager = new RentalInfoVO(rs.getString("managerid"),rs.getString("managerpw"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return manager;
	}
	
	public void insert(String id, String pw, String name, String birth, String phone, String email, Date regdate) {

	    String sql = "INSERT INTO membership VALUES (?,?,?,?,?,?,?)";
	    
	    try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);
			pstmt.setString(5, phone);
			pstmt.setString(6, email);
			pstmt.setDate(7, (java.sql.Date) regdate);
			
			int Count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 	    
	}

	public ObservableList<MembershipVO> selectAll(String text) {
		ObservableList<MembershipVO> list = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT mid,mname,mbirth,mphonenumber,memail,mregdate ");
		sql.append("FROM membership ");
		sql.append("WHERE mid like ? ");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+text+"%");
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while (rs.next()) {
				MembershipVO book = new MembershipVO(rs.getString("mid"),rs.getString("mname"),rs.getString("mbirth"),rs.getString("mphonenumber"),rs.getString("memail"),rs.getDate("mregdate"));
	            list.add(book);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	
	
}

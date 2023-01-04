package project.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javafx.collections.ObservableList;
import project.jdbc.dao.DBCPConnectionPool;
import project.jdbc.dao.MembershipDAO;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;

public class MembershipService {

	public boolean selectMemberByID(String loginId, String loginpw) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		MembershipVO membership = dao.select(loginId, loginpw);
		
		if(membership==null)
		{ return false;
		}else if(loginId.equals(membership.getMid()) && loginpw.equals(membership.getMpw())) {
				return true;
			} else {
				return false;
			} 
	}

	public RentalInfoVO selectManagerByID(String managerId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		RentalInfoVO manager = dao.selectmanager(managerId);
	
		return manager;
	}
	
	public void insertMemberInfo(String id, String pw, String name, String birth, String phonenumber, String email, Date regdate) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		dao.insert(id,pw,name,birth,phonenumber,email,regdate);
		
		
	}

	public ObservableList<MembershipVO> selectMemberByKeyword(String text) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		ObservableList<MembershipVO> list = dao.selectAll(text);
		
		return list;
	}

	
}

package project.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import project.jdbc.dao.DBCPConnectionPool;
import project.jdbc.dao.MembershipDAO;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;

public class MembershipService {

	public MembershipVO selectMemberByID(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		MembershipVO membership = dao.select(loginId);
		
		return membership;
		
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
	
	public void insertMemberInfo(String id, String pw, String name, String birth, String phone, String email) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		dao.insert(id,pw,name,birth,phone,email);
		
		
	}

	
}

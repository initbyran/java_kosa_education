package project.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.ObservableList;
import project.jdbc.dao.DBCPConnectionPool;
import project.jdbc.dao.MembershipDAO;
import project.jdbc.vo.MembershipVO;
import project.jdbc.vo.RentalInfoVO;
import project.jdbc.mybatis.MyBatisConnectionFactory;

public class MembershipService {

	public boolean selectMemberByID(String loginId, String loginpw) {
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		MembershipDAO dao = new MembershipDAO(factory);
		
		MembershipVO membership = dao.select(loginId, loginpw);
		
		if(membership==null)
		{ return false;
		}else if(loginId.equals(membership.getMid()) && loginpw.equals(membership.getMpw())) {
				return true;
			} else {
				return false;
			} 
	}

	public RentalInfoVO selectManagerByID(String loginId) {
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		MembershipDAO dao = new MembershipDAO(factory);
		RentalInfoVO manager = dao.selectManager(loginId);
	
		return manager;
	}
	
	public void insertMemberInfo(String id, String pw, String name, String birth, String phonenumber, String email, Date regdate) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		MembershipDAO dao = new MembershipDAO(factory);
		dao.insert(id,pw,name,birth,phonenumber,email,regdate);
		
		
	}

	public MembershipVO selectMember(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MembershipVO membership = new MembershipVO();
		MembershipDAO dao = new MembershipDAO(con);
		membership = dao.selectOne(loginId);
		return membership;
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

	public ObservableList<MembershipVO> deleteMember(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		
		int count = dao.delete(loginId);
		
		ObservableList<MembershipVO> list = dao.selectAll(loginId);
		return list;
	}

	public void updateMemberInfo(String id, String pw, String name, String birth, String phonenumber, String email, String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		
		int count = dao.updateM(id,pw,name,birth,phonenumber,email,loginId);
		
	}

	public void updateReturnPoint(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		
		int count = dao.updatePP(loginId);
		
	}

	public void updateOverduePoint(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		
		int count = dao.updateMP(loginId);
	}

	public int selectPoint(String loginId) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MembershipDAO dao = new MembershipDAO(con);
		
		int point = dao.selectP(loginId);
		return point;
	}

	
	
}

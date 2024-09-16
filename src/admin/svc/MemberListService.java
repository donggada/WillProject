package admin.svc;

import static member.db.JdbcUtill.*;


import java.sql.Connection;
import java.util.ArrayList;

import admin.dao.AdminDAO;
import member.vo.MemberBean;

public class MemberListService {

	public int getListCount(String target,String table) {
		System.out.println("MemberListService - getListCount()");
		int listCount = 0;
		
		
		Connection con = getConnection();
		
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
	
		listCount = adao.selectListCount(target,table);
		
		close(con);
		
		return listCount;	
		
	
	}

	public ArrayList<MemberBean> getArticleList(int page, int limit) {
		System.out.println("MemberListService - getArticleList()");
		ArrayList<MemberBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectMemberList(page, limit);
		
		
		close(con);
		
		return memberList;
		
	}

	public ArrayList<MemberBean> getArticleList(int page, int limit, String parameter) {
		System.out.println("MemberListService - getArticleList()");
		ArrayList<MemberBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectMemberList(page, limit, parameter);
		
		
		close(con);
		
		return memberList;
	}

	
	public ArrayList<MemberBean> getArticleSearchList(int page, int limit, String select, String search) {
		ArrayList<MemberBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectMemberSearchList(page, limit, select, search);
		
		
		close(con);
		
		return memberList;
	}

	public ArrayList<MemberBean> getArticleListlineup(int page, int limit, String line, String targetup) {
	ArrayList<MemberBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectMemberSearchListlineup(page, limit, line, targetup);
		
		
		close(con);
		
		return memberList;
	}
	
	public MemberBean selectMemberBean(String id) {
	MemberBean memberBean = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberBean = adao.selectMemberBean(id);
		
		
		close(con);
		
		return memberBean;
	}

}

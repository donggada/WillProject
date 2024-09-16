package admin.svc;

import static member.db.JdbcUtill.close;
import static member.db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.dao.AdminDAO;
import admin.vo.CarBean;
import member.vo.MemberBean;

public class CarListService {

	public int getListCount(String taget,String table) {
		System.out.println("CarListService - getListCount()");
//		System.out.println(table);
		int listCount = 0;
		
		
		Connection con = getConnection();
		
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
	
		listCount = adao.selectListCount(taget,table);
		
		close(con);
		
		return listCount;	
	}
	
	public int getListCount(String taget,String table,String carsearch1,String carsearch2) {
		System.out.println("CarListService - getListCount()");
//		System.out.println(table);
		int listCount = 0;
		
		
		Connection con = getConnection();
		
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		
	
		listCount = adao.selectListCount(taget,table,carsearch1,carsearch2);
		
		close(con);
		
		return listCount;	
	}

	public ArrayList<CarBean> getArticleList(int page, int limit) {
	//	System.out.println("CarListService - getArticleList()");
		ArrayList<CarBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectCarList(page, limit);
		
		
		close(con);
		
		return memberList;
	}

	public ArrayList<CarBean> getArticleListlineup(int page, int limit, String line, String targetup) {
		ArrayList<CarBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectCarListlinep(page, limit,line, targetup);
		
		
		close(con);
		
		return memberList;
	}
	
	
	
	

	

}

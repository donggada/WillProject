package info.svc;

import info.vo.ListBean;
import qna.dao.qnaBoardDAO;

import static info.db.jdbcutil.*;
import static qna.db.jdbcutil.getconnection;

import java.sql.Connection;
import java.util.ArrayList;

import info.dao.mypageDAO;

public class infoListService {

	public ListBean checkList(String id) {
		
		ListBean lb = new ListBean();
		mypageDAO dao = mypageDAO.getinstance();
		Connection con = getconnection();
		dao.setCon(con);
		
		lb = dao.checkMember(id);
		close(con);

		return lb;
	}

	public ArrayList<ListBean> getBookList(String id, int page, int limit) {
		
		ArrayList<ListBean> list = new ArrayList<ListBean>();
		mypageDAO dao = mypageDAO.getinstance();
		Connection con = getconnection();
		dao.setCon(con);
		list = dao.checkBook(id, page, limit);
		close(con);
		return list;
	}

	public int getListCount(String id) {
		
		int count = 0;
		
		Connection con = getconnection();
		mypageDAO dao = mypageDAO.getinstance();
		dao.setCon(con);
		count=dao.getListCount(id);
		
		close(con);
		
		return count;
	}
	
}

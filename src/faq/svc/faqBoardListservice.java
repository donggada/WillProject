package faq.svc;

import static faq.db.jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import faq.dao.faqBoardDAO;
import faq.vo.faqBoardbean;




public class faqBoardListservice {

	
	public int getlistcount() {
		int listcount = 0;
		
		Connection con=getconnection();
		faqBoardDAO faqBoard=faqBoardDAO.getinstance();
		faqBoard.setCon(con);
		listcount=faqBoard.selectlist();


		close(con);
		return listcount;
		

		
	}

	
	
	
	public ArrayList<faqBoardbean> getarticlelist(int page, int limit) {
		ArrayList<faqBoardbean> articlelist=null;
		
		Connection con=getconnection();
		faqBoardDAO faqBoard=faqBoardDAO.getinstance();
		faqBoard.setCon(con);
		
		
		articlelist=faqBoard.selectarticlelist(page,limit);
		
		
		
		close(con);
		return articlelist;
		
	}




	public ArrayList<faqBoardbean> getarticlelist2(int page, int limit) {
	ArrayList<faqBoardbean> articlelist=null;
		
		Connection con=getconnection();
		faqBoardDAO faqBoard=faqBoardDAO.getinstance();
		faqBoard.setCon(con);
		
		
		articlelist=faqBoard.selectarticlelist2(page,limit);
		
		
		
		close(con);
		return articlelist;
	}
	
	
	
}

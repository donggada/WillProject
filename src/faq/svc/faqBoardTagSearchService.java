package faq.svc;

import static faq.db.jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import faq.dao.faqBoardDAO;
import faq.vo.faqBoardbean;




public class faqBoardTagSearchService {

	
	public int getlistcount(String tag) {
		int listcount = 0;
		
		Connection con=getconnection();
		faqBoardDAO faqBoard=faqBoardDAO.getinstance();
		faqBoard.setCon(con);
		listcount=faqBoard.tagselectlist(tag);


		close(con);
		return listcount;
		

		
	}

	
	
	
	public ArrayList<faqBoardbean> getarticlelist(int page, int limit, String tag) {
		//System.out.println(tag+"서비스조회");
		ArrayList<faqBoardbean> articlelist=null;
		
		Connection con=getconnection();
		faqBoardDAO faqBoard=faqBoardDAO.getinstance();
		faqBoard.setCon(con);
		
		
		articlelist=faqBoard.tagselectlist(page,limit,tag);
		
		
		
		close(con);
		return articlelist;
		
	}
	
	
	
}

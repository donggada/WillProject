package faq.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import faq.svc.faqBoardListservice;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;
import faq.vo.pageinfo;

public class faqBoardListaction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		
		int page=1;
		int limit=5;

		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		
		faqBoardListservice boardlist=new faqBoardListservice(); 
		
		int listcount = boardlist.getlistcount();

		ArrayList<faqBoardbean> articlelist=boardlist.getarticlelist2(page,limit);

		
		int maxpage = (int)((double)listcount/limit +0.95);

		
		int startpage=((int)((double)page/10+0.9)-1)*10+1;
		int endpage= startpage+10-1;
		
		
		if(endpage>maxpage) {
			endpage=maxpage;
		}
	
	
		pageinfo pageinfo = new pageinfo(page, maxpage, startpage, endpage, listcount);
		
		request.setAttribute("pageinfo", pageinfo);
		request.setAttribute("articlelist", articlelist);
		
		
		forward= new actionForward();
		forward.setRedirect(false);
		forward.setPath("/FAQ/FAQ_list.jsp");
		
		return forward;
	}

	
}

package faq.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.svc.faqBoardListservice;
import faq.svc.faqBoardSearchService;
import faq.svc.faqBoardTagSearchService;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;
import faq.vo.pageinfo;

public class faqBoardTagSearchAction2 implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		int page=1;
		int limit=5;
		String tag=request.getParameter("tag");
//		System.out.println(tag);
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		faqBoardTagSearchService boardlist=new faqBoardTagSearchService();
		
		int listcount = boardlist.getlistcount(tag);

		ArrayList<faqBoardbean> articlelist=boardlist.getarticlelist(page, limit, tag);

		
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
		forward.setRedirect(false); // 기본값이므로 생략이 가능 
		forward.setPath("/FAQ/FAQ_list.jsp");
		
		
		
		return forward;
	}

}

package qna.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.action.action;
import qna.svc.qnaBoardListservice;
import qna.vo.actionForward;
import qna.vo.pageinfo;
import qna.vo.qnaBoardbean;

public class qnaBoardAdminListaction2 implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		
		int page=1;
		int limit=10;

		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		HttpSession session=request.getSession();
	
		
		qnaBoardListservice boardlist=new qnaBoardListservice(); 
		int listcount=0;
		ArrayList<qnaBoardbean> articlelist=null;
		
		

		listcount = boardlist.getlistcount4();
		articlelist=boardlist.getarticlelist4(page, limit);
			

		
		
		int maxpage = (int)((double)listcount/limit +0.95);
		int startpage=((int)((double)page/10+0.9)-1)*10+1;
		int endpage= startpage+10-1;
		if(endpage>maxpage) {
			endpage=maxpage;
		}
		pageinfo pageinfo = new pageinfo(page, maxpage, startpage, endpage, listcount);
		

		
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("articlelist", articlelist);

		
		forward= new actionForward();
		forward.setRedirect(false);
		forward.setPath("/Admin/qna_list.jsp");
		
		return forward;
	}

	
}

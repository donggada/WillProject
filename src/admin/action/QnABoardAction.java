package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.QnaAdminBoardService;
import member.action.Action;
import member.vo.ActionForward;
import qna.svc.qnaBoardListservice;
import qna.vo.pageinfo;
import qna.vo.qnaBoardbean;

public class QnABoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("QnABoardAction");
		ActionForward forward=null;
		
		int page=1;
		int limit=10;
		
		QnaAdminBoardService qbls=new QnaAdminBoardService();
		ArrayList<qnaBoardbean> articlelist=qbls.QnaAdminBoardList(page,limit);
		
		qnaBoardListservice boardlist=new qnaBoardListservice(); 
		
		int listcount = boardlist.getlistcount2();
		articlelist=boardlist.getarticlelist(page, limit);
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int maxpage = (int)((double)listcount/limit +0.95);

		
		int startpage=((int)((double)page/10+0.9)-1)*10+1;
		int endpage= startpage+10-1;
		
		
		if(endpage>maxpage) {
			endpage=maxpage;
		}

		pageinfo pageinfo = new pageinfo(page, maxpage, startpage, endpage, listcount);
		

		
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("articlelist", articlelist);

		
		forward=new ActionForward();
		forward.setPath("/Admin/qna_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

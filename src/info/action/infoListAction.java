package info.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.svc.infoListService;
import info.vo.ActionForward;
import info.vo.ListBean;
import info.vo.pageinfo;

public class infoListAction implements Action {

	@Override
	public ActionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("Member_id");
		ActionForward forward = new ActionForward();
		infoListService service = new infoListService();
		ListBean lb = service.checkList(id);
		int page=1;
		int limit=10;
		int listcount=0;
		if(request.getParameter("page")!=null) 
		{
			page=Integer.parseInt(request.getParameter("page"));
		}
		listcount = service.getListCount(id);
		ArrayList<ListBean> list = service.getBookList(id, page, limit);
		
		int maxpage = (int)((double)listcount/limit +0.95);
		int startpage=((int)((double)page/10+0.9)-1)*10+1;
		int endpage= startpage+10-1;
		if(endpage>maxpage) {
			endpage=maxpage;
		}
		
		pageinfo pageinfo = new pageinfo(page, maxpage, startpage, endpage, listcount);

		
		request.setAttribute("list", list);
		request.setAttribute("bean", lb);
		request.setAttribute("pageinfo", pageinfo);
		forward.setPath("/myPage/info.jsp");
		return forward;
	}

}

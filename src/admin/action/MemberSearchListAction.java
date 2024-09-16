package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.MemberListService;
import book.svc.BookListService;
import book.vo.BookBean;
import member.action.Action;
import member.vo.ActionForward;
import member.vo.MemberBean;
import qna.vo.pageinfo;

public class MemberSearchListAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		int page = 1; 
		int limit = 10;
		String target="member_id";
		String table="member";
		//String table=request.getParameter("table");
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")); 
		}
		
		String select= request.getParameter("select");
		String search=request.getParameter("search");
		
		
		
		MemberListService MemberListService = new MemberListService();
		BookListService booklist= new BookListService();
		
		ArrayList<MemberBean> MemberList =null;
		ArrayList<BookBean> booklist2=null;
		
		int listCount = MemberListService.getListCount(target,table);
		
	
		MemberList = MemberListService.getArticleSearchList(page, limit, select, search);
		booklist2 = booklist.getmmcount();	
	
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		
		
		int startPage = ((int)((double)page / 10 + 0.9) - 1) * 10 + 1;
		
		
		int endPage = startPage + 10 - 1;
		
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		pageinfo pageInfo = new pageinfo(page, maxPage, startPage, endPage, listCount);
		
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articlelist", MemberList);
		request.setAttribute("booklist2", booklist2);
		
		
		forward = new ActionForward();
		forward.setPath("/Admin/mmlistadmin.jsp");
		forward.setRedirect(false);
		
		
		
		
		return forward;
	}

}

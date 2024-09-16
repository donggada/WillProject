package admin.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.MemberListService;
import book.svc.BookListService;
import book.vo.BookBean;
import member.action.Action;
import member.vo.ActionForward;
import member.vo.MemberBean;
import qna.vo.pageinfo;

public class MemberListAction extends ActionForward implements Action {

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
		
		//정렬기준 추가
		int lineup=0;
		String line=null;
		if(request.getParameter("lineup")!=null) {
			lineup = Integer.parseInt(request.getParameter("lineup"));	
		}
		
		if(lineup==0) {
			line="desc";
		}else {
			line="asc";
		}
		//정렬항목 추가
		String targetup=null;
		if(request.getParameter("target")!=null) {
			targetup=request.getParameter("target");	
		}
	
		
		
		MemberListService MemberListService = new MemberListService();
		BookListService booklist= new BookListService();
		
		ArrayList<MemberBean> MemberList =null;
		ArrayList<BookBean> booklist2=null;
		
		int listCount = MemberListService.getListCount(target,table);
		
		if(request.getParameter("id")==null&targetup==null) {
			MemberList = MemberListService.getArticleList(page, limit);
			 booklist2 = booklist.getmmcount();	
		}else if(request.getParameter("id")==null&&targetup!=null) {
			MemberList = MemberListService.getArticleListlineup(page, limit, line, targetup);
			booklist2 = booklist.getmmcount();	
		}else if(request.getParameter("id")!=null) {
			MemberList = MemberListService.getArticleList(page, limit, request.getParameter("id"));
			 booklist2 = booklist.getmmcount();	
		}
		
		
		
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		
		
		int startPage = ((int)((double)page / 10 + 0.9) - 1) * 10 + 1;
		
		
		int endPage = startPage + 10 - 1;
		
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		pageinfo pageInfo = new pageinfo(page, maxPage, startPage, endPage, listCount);
		
		HashMap<String, BookBean> book=new HashMap<String, BookBean>();
		for(BookBean bb : booklist2) {
			book.put(bb.getMember_id(), bb);
		}
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articlelist", MemberList);
		request.setAttribute("book", book);
//		request.setAttribute("booklist2", booklist2);
		request.setAttribute("lineup", lineup);//정렬상태 전달
		
		
		forward = new ActionForward();
		forward.setPath("/Admin/mmlistadmin.jsp");
		forward.setRedirect(false);
		
		
		
		
		return forward;
	}

}

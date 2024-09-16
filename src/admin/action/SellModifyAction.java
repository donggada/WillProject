package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.MemberListService;
import admin.svc.MembermodifyService;
import book.svc.BookListModifyService;
import book.svc.BookListService;
import book.vo.BookBean;
import member.action.Action;
import member.vo.ActionForward;
import member.vo.MemberBean;
import qna.vo.pageinfo;

public class SellModifyAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		int page = 1; 
		int limit = 10;
//		String taget="member_id";
		String table="book";
		String taget=request.getParameter("member_id");
		int num=Integer.parseInt(request.getParameter("num"));
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")); 
		}
		
	
		
		BookListService booklist=new BookListService();
		BookBean article=booklist.getbookdetail(num);
//		System.out.println(article.getBook_date());
		
		
		request.setAttribute("article", article);
	
		
		forward = new ActionForward();
		forward.setPath("/Admin/sell_modify.jsp");
		forward.setRedirect(false);
		
		
		
		
		return forward;
	}

}

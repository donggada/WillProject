package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.CarListService;
import admin.svc.MemberListService;
import admin.vo.CarBean;
import book.svc.BookListService;
import book.vo.BookBean;
import member.action.Action;
import member.vo.ActionForward;
import member.vo.MemberBean;
import qna.vo.pageinfo;

public class sellingListSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		BookListService bookListService = new BookListService();
		String year=request.getParameter("YEAR");
		String month=request.getParameter("MONTH");
	
		String select= request.getParameter("select");
		String search=request.getParameter("search");

	
		
		ArrayList<BookBean> bookList = null;
		
		
		int sum=0;
		int count=0;
		int c=0;
		int c2=0;
		int f=0;
		int fs=0;
		int fs2=0;
		
		if(search!=null) {
			bookList = bookListService.getBooksearchList(select, search);
			
		}else if(year==null||month==null) {
			bookList = bookListService.getBookList();
			
		}else if(year!=null&&month!=null){
			if(month.equals("10")||month.equals("11")||month.equals("12")) {
				String str1=year+"-"+month+"-01";
				String str2=year+"-"+month+"-31";	
				bookList = bookListService.getBookList2(str1,str2); //월 리스트
				sum=bookListService.getBooksum(str1,str2); //월합계
				count=bookListService.getBookcount(str1,str2); //월건수
				c=bookListService.getBookc(str1, str2); //금액증감
				c2=bookListService.getBookc2(str1, str2); //건수증감
				f=bookListService.getBookf(str1, str2); //미수건수조회
				fs=bookListService.getBookfs(str1, str2); //미수금액총액
				fs2=bookListService.getBookfs2(str1, str2); //미수비율
				
			}else {
				String str1=year+"-0"+month+"-01";
				String str2=year+"-0"+month+"-31";
				bookList = bookListService.getBookList2(str1,str2);
				sum=bookListService.getBooksum(str1,str2);
				count=bookListService.getBookcount(str1,str2);
				c=bookListService.getBookc(str1, str2);
				c2=bookListService.getBookc2(str1, str2); //건수증감
				f=bookListService.getBookf(str1, str2); //미수건수조회
				fs=bookListService.getBookfs(str1, str2); //미수금액총액
				fs2=bookListService.getBookfs2(str1, str2); //미수비율
			}

			
		}
		
		
//		System.out.println("건수증감"+c2);
//		System.out.println("금액증감"+c);
		
		

		request.setAttribute("bookList", bookList);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("sum", sum);
		request.setAttribute("count", count);
		request.setAttribute("c", c);
		request.setAttribute("c2", c2);
		request.setAttribute("f", f);
		request.setAttribute("fs", fs);
		
		forward = new ActionForward();
		forward.setPath("/Admin/sellinglist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
		
	}

}

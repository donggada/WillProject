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

public class sellingListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		BookListService bookListService = new BookListService();
		String year=request.getParameter("YEAR");
		String month=request.getParameter("MONTH");
		
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

		String state=null;
		if(request.getParameter("state")!=null) {
			state=request.getParameter("state");
		}
	
		
		ArrayList<BookBean> bookList = null;
		
		
		int sum=0;
		int count=0;
		int c=0;
		int c2=0;
		int f=0;
		int fs=0;
		int fs2=0;
		
		if(year==null&&month==null&&targetup!=null&&state==null) {
//			System.out.println(targetup);
//			System.out.println("결제상태"+state);
//			System.out.println("1");
			bookList = bookListService.getBookListlineup(line, targetup);
		}else if(state!=null&&targetup==null) {
			bookList = bookListService.getBookstateList(state);
			System.out.println("2");
		}else if(year==null&&month==null&&targetup==null&&state==null) {
			System.out.println("3");
			bookList = bookListService.getBookList();
		}else if(year==null&&month==null&&targetup==null&&state!=null) {
			System.out.println("4");
			bookList = bookListService.getBookstateListlineup2(state, targetup, line);
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
		request.setAttribute("lineup", lineup);//정렬상태 전달
		request.setAttribute("state", state);
		
		
		forward = new ActionForward();
		forward.setPath("/Admin/sellinglist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
		
	}

}

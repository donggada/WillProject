package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import book.svc.BookModifyService;
import book.vo.BookBean;
import member.action.Action;
import member.vo.ActionForward;


public class SellModifyProAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		System.out.println("SellModifyProAction");
//		int page = 1; 
//		int limit = 10;
//		if(request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page")); 
//		}
//		
		
		
		BookBean bb=new BookBean();
		bb.setBook_state(Integer.parseInt(request.getParameter("book_state")));
		bb.setBook_num(Integer.parseInt(request.getParameter("num")));
		
//		System.out.println(Integer.parseInt(request.getParameter("book_state")));
//		System.out.println(Integer.parseInt(request.getParameter("num")));
//		
		BookModifyService bookmodyfy=new BookModifyService();
		boolean ismodify = bookmodyfy.mmmodify(bb);
	
		
		
		
		if(!(ismodify)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('수정실패')"); 
			out.println("history.back()");
			out.println("</script>"); 
			
		}else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("sellinglist.ad");
		
		}
		
		
		
		
		return forward;
	}

}

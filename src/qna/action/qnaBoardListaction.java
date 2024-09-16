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

public class qnaBoardListaction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		
		int page=1;
		int limit=4;

		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("Member_id"); 
//		System.out.println(id);
		
		qnaBoardListservice boardlist=new qnaBoardListservice(); 
		int listcount=0;
		ArrayList<qnaBoardbean> articlelist=null;

		//관리자계정인 admin만 전체글 조회
		
	
		
		if(id==null) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>"); 
		out.println("alert('로그인이 필요합니다.')"); 
		out.println("history.back()");
		out.println("</script>"); 
		} else {
			
			if(id.equals("admin")) {
				listcount = boardlist.getlistcount2();
				articlelist=boardlist.getarticlelist(page,limit);
			
			}else if(!(id.equals("admin"))&&id !=null) {
				listcount = boardlist.getlistcount(id);
				articlelist=boardlist.getrearticlelist(page, limit, id);
			}
			
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
		forward.setRedirect(false);
		forward.setPath("/QnA/qna_list.jsp");
		}
		
		return forward;
	}

	
}

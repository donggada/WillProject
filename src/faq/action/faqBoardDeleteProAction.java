package faq.action;

import java.io.PrintWriter;
import java.sql.Array;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import faq.svc.faqBoardDeleteService;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;



public class faqBoardDeleteProAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); 
		String page=request.getParameter("page");
		
		String[] num =request.getParameterValues("check");
		int[] num2 = Arrays.stream(num).mapToInt(Integer::parseInt).toArray();
		
		
		faqBoardbean boardbean= new faqBoardbean();
		faqBoardDeleteService boarddelete=new faqBoardDeleteService();
		int result=-1;
		
		
		if(num==null) {
			result=-1;
		}
		
		for(int val:num2){
			//System.out.println(val);
			boardbean.setFaqboard_num(val);
			boarddelete.delete(boardbean);
			result=1;
		}
	
		
	
		

		
		
		if(result==0) {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('삭제권한이 없습니다.')");
			out.println("history.back()"); 
			out.println("</script>"); 
			
		}if(result==-1) {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('삭제할 항목이 선택되지 않았습니다.')");
			out.println("history.back()"); 
			out.println("</script>"); 
			
		}else {
			forward=new actionForward();
			forward.setRedirect(false);
			forward.setPath("faqadminlist.fbo?"+"&page="+page);
		
		}
		
		
		
		
		return forward;
	}
	}


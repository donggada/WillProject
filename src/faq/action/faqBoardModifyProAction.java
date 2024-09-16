package faq.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import faq.svc.faqBoardModifyService;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;


public class faqBoardModifyProAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");

		int faqboard_num=Integer.parseInt(request.getParameter("faqBoard_num"));
		String page=request.getParameter("page");
		
//		System.out.println(faqboard_num);
//		System.out.println(page);
//		System.out.println(request.getParameter("faqBoard_content"));
//		System.out.println(request.getParameter("faqBoard_subject"));
//		System.out.println(request.getParameter("tag"));

		
		
		faqBoardbean qnaboardbean= new faqBoardbean();
		qnaboardbean.setFaqboard_content(request.getParameter("faqBoard_content"));
		qnaboardbean.setFaqboard_subject(request.getParameter("faqBoard_subject"));
		qnaboardbean.setFaqBoard_tag(request.getParameter("tag"));
		qnaboardbean.setFaqboard_num(faqboard_num);
		

		faqBoardModifyService qnaBoardModifyService= new faqBoardModifyService();
		
		boolean iswritesucce= qnaBoardModifyService.regisartiset(qnaboardbean);
//		System.out.println(iswritesucce+"수정결과");
		
		

		
		if(!(iswritesucce)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('수정실패')"); 
			out.println("history.back()");
			out.println("</script>"); 
			
		}else {
			forward=new actionForward();
			forward.setRedirect(true);
			forward.setPath("faqadminlist.fbo?"+"&page="+page);
		
		}
		
		return forward;
	}


}




package faq.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.svc.faqBoardDetailService;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;




public class faqBoardModifyAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		int qnaboardnum=Integer.parseInt(request.getParameter("faqBoard_num"));
		String page=request.getParameter("page");
//		System.out.println(page);
//		System.out.println(qnaboardnum);
		
		faqBoardDetailService detail=new faqBoardDetailService();
		faqBoardbean article= detail.detail(qnaboardnum);
		
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		
		
		forward= new actionForward();
		forward.setRedirect(false);
		forward.setPath("/Admin/faq_modify.jsp");
		
		
		
		
		
		
		
		return forward;
	}

}

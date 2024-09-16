package qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.svc.qnaBoardDetailService;
import qna.vo.actionForward;
import qna.vo.qnaBoardbean;


public class qnaBoardModifyAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		
		int qnaboardnum=Integer.parseInt(request.getParameter("qnaboard_num"));
		String page=request.getParameter("page");
//		System.out.println(page);
//		System.out.println(qnaboardnum);
		
		qnaBoardDetailService detail=new qnaBoardDetailService();
		qnaBoardbean article= detail.detail(qnaboardnum);
		
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		
		
		forward= new actionForward();
		forward.setRedirect(false);
		forward.setPath("/QnA/qna_modify.jsp");
		
		
		
		
		
		
		
		return forward;
	}

}

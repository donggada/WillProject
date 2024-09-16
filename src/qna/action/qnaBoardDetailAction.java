package qna.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.action.action;
import qna.svc.qnaBoardCheckService;
import qna.svc.qnaBoardDetailService;
import qna.vo.actionForward;
import qna.vo.qnaBoardbean;

public class qnaBoardDetailAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward = null;
		
		
		int qnaboardnum=Integer.parseInt(request.getParameter("qnaBoard_num"));
		String page=request.getParameter("page");
		String qnaboard_pass=request.getParameter("qnaBoard_pass");
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("Member_id"); 
		
//		System.out.println("action"+id);
//		System.out.println(qnaboardnum);
		//System.out.println(qnaboard_pass);
		
		
		qnaBoardbean article = new qnaBoardbean();
		article.setQnaBoard_num(qnaboardnum);
		article.setQnaBoard_pass(qnaboard_pass);
		int result=0;
		
		
		//관리자는 비번체크X
		if(id.equals("admin")) {
			result=1;
		}
		else {
		qnaBoardCheckService chek=new qnaBoardCheckService();
		result=chek.check(article);
		}
		
		
		
		if(result==0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가  틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
			
		}else {
			System.out.println("서비스시작");
			qnaBoardDetailService detail=new qnaBoardDetailService();
			article= detail.detail(qnaboardnum);
			request.setAttribute("article", article);
			request.setAttribute("page", page);
			forward= new actionForward();
			forward.setRedirect(false); 
			forward.setPath("/QnA/qna_veiw.jsp");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		

		
		
		return forward;
	}

}

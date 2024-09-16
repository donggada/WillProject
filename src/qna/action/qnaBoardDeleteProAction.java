package qna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.svc.qnaBoardCheckService;
import qna.svc.qnaBoardDeleteService;
import qna.vo.actionForward;
import qna.vo.qnaBoardbean;


public class qnaBoardDeleteProAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");
		int boardnum=Integer.parseInt(request.getParameter("qnaBoard_num"));
		String page=request.getParameter("page");
		String boardpass=request.getParameter("qnaBoard_pass");
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("Member_id"); 
		
		
		
		qnaBoardbean boardbean= new qnaBoardbean();
		boardbean.setQnaBoard_num(boardnum);
		boardbean.setQnaBoard_pass(boardpass);
	
		
		int result=0;
		qnaBoardDeleteService boarddelete= new qnaBoardDeleteService();

		
		//관리자는 비번입력없이 삭제
		if(id.equals("admin")) {
			result=boarddelete.delete2(boardbean);
		}
		else {
			result=boarddelete.delete(boardbean);
		}
		
		

		
		
		if(result==0) {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('삭제권한이 없습니다.')");
			out.println("history.back()"); 
			out.println("</script>"); 
			
		}else {
			forward=new actionForward();
			forward.setRedirect(true);
			forward.setPath("qnaBoardlist.bo?"+"&page="+page);
		
		}
		
		
		
		
		return forward;
	}
	}


package faq.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import faq.svc.faqBoardWriteProService;
import faq.vo.actionForward;
import faq.vo.faqBoardbean;


public class faqWriteProAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");
		String uploadpath=request.getRealPath("/upload");
		String ip=request.getRemoteAddr();
		System.out.println(ip);
		int maxsize = 10*1024*1024;

		MultipartRequest multi=new MultipartRequest(request,uploadpath,maxsize,"utf-8",new DefaultFileRenamePolicy());

		
		
		faqBoardbean qnaboardbean= new faqBoardbean();
		qnaboardbean.setFaqboard_subject(multi.getParameter("faqBoard_subject"));
		qnaboardbean.setFaqboard_content(multi.getParameter("faqBoard_content"));
		qnaboardbean.setFaqBoard_tag(multi.getParameter("tag"));
	

		faqBoardWriteProService qnaboardwriteproservice= new faqBoardWriteProService();
		
		boolean iswritesucce= qnaboardwriteproservice.regisartiset(qnaboardbean);
//		System.out.println(iswritesucce+"글쓰기결과");
		
		

		
		if(!(iswritesucce)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('글 등록 실패')"); 
			out.println("history.back()");
			out.println("</script>"); 
			
		}else {
			forward=new actionForward();
			forward.setRedirect(true);
			forward.setPath("faqadminlist.fbo");
		
		}
		
		return forward;
	}


}




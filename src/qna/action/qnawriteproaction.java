package qna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import qna.action.action;
import qna.svc.qnaBoardWriteProService;
import qna.vo.actionForward;
import qna.vo.qnaBoardbean;

public class qnawriteproaction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");
		String uploadpath=request.getRealPath("/upload");
		String ip=request.getRemoteAddr();
//		System.out.println(ip);

		int maxsize = 10*1024*1024;


		MultipartRequest multi=new MultipartRequest(request,uploadpath,maxsize,"utf-8",new DefaultFileRenamePolicy());
//		System.out.println(multi.getParameter("qnaBoard_id"));
//		System.out.println(multi.getParameter("qnaBoard_pass"));
//		System.out.println(multi.getParameter("qnaBoard_subject"));
//		System.out.println(multi.getParameter("qnaBoard_content"));
//		System.out.println(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
//		System.out.println(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		String page=request.getParameter("page");
//		System.out.println(multi.getParameter("tag"));
		
		
		qnaBoardbean qnaboardbean= new qnaBoardbean();
		qnaboardbean.setQnaBoard_id(multi.getParameter("qnaBoard_id"));
		qnaboardbean.setQnaBoard_pass(multi.getParameter("qnaBoard_pass"));
		qnaboardbean.setQnaBoard_subject(multi.getParameter("qnaBoard_subject"));
		qnaboardbean.setQnaBoard_content(multi.getParameter("qnaBoard_content"));
		qnaboardbean.setQnaBaord_tag(multi.getParameter("tag"));
		qnaboardbean.setQnaBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	

		qnaBoardWriteProService qnaboardwriteproservice= new qnaBoardWriteProService();
		
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
			forward.setPath("qnaBoardlist.bo");
		
		}
		
		return forward;
	}


}




package qna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import qna.action.action;
import qna.svc.qnaBoardModifyService;
import qna.svc.qnaBoardWriteProService;
import qna.vo.actionForward;
import qna.vo.qnaBoardbean;

public class qnaBoardModifyProAction implements action {

	@Override
	public actionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		actionForward forward=null;
		request.setCharacterEncoding("UTF-8");
		String uploadpath=request.getRealPath("/upload");
		String ip=request.getRemoteAddr();
		System.out.println(uploadpath);

		int maxsize = 10*1024*1024;

		int qnaboard_num=Integer.parseInt(request.getParameter("qnaboard_num"));
		MultipartRequest multi=new MultipartRequest(request,uploadpath,maxsize,"utf-8",new DefaultFileRenamePolicy());
		String page=request.getParameter("page");

		
		
		qnaBoardbean qnaboardbean= new qnaBoardbean();
		qnaboardbean.setQnaBoard_id(multi.getParameter("qnaBoard_id"));
		qnaboardbean.setQnaBoard_pass(multi.getParameter("qnaBoard_pass"));
		qnaboardbean.setQnaBoard_subject(multi.getParameter("qnaBoard_subject"));
		qnaboardbean.setQnaBoard_content(multi.getParameter("qnaBoard_content"));
		qnaboardbean.setQnaBaord_tag(multi.getParameter("tag"));
		qnaboardbean.setQnaBoard_num(qnaboard_num);
		qnaboardbean.setQnaBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	

		qnaBoardModifyService qnaBoardModifyService= new qnaBoardModifyService();
		
		boolean iswritesucce= qnaBoardModifyService.regisartiset(qnaboardbean);
//		System.out.println(iswritesucce+"수정결과");
		
		

		
		if(!(iswritesucce)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('비밀번호가 다릅니다.')"); 
			out.println("history.back()");
			out.println("</script>"); 
			
		}else {
			forward=new actionForward();
			forward.setRedirect(true);
			forward.setPath("qnaBoardlist.bo?board_num="+qnaboard_num+"&page="+page);
		
		}
		
		return forward;
	}


}




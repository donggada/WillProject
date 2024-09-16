package admin.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.svc.PopupPageUploadService;
import member.action.Action;
import member.vo.ActionForward;
import review.vo.ReviewBean;

public class PopupPageUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		boolean isUpload=false;
		System.out.println("PopupPageUploadAction");
		String PopUPloadfile= request.getParameter("image");
		
		
		String realFolder = "";
		String saveFolder = "/EventUploadfile";
		int fileSize = 1024*1024*1024;
		// realFolder = request.getRealPath("/EventUploadfile");
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);

		
		MultipartRequest multi = new MultipartRequest(request, realFolder,fileSize, "UTF-8", new DefaultFileRenamePolicy());
		ReviewBean reviewBean = new ReviewBean();
		reviewBean.setReview_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		PopupPageUploadService ppul=new PopupPageUploadService();
		isUpload=ppul.PoPUploade(reviewBean);
		
		
		
		if(isUpload) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("Admin/PoP-UpPage.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out1 = response.getWriter(); 
			out1.println("<script>"); 
			out1.println("alert('등록실패!')"); 
			out1.println("history.back()");
			out1.println("</script>"); 	
		}
		
		return forward;
	}

}

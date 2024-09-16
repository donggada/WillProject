package info.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.svc.infoDeleteService;
import info.vo.ActionForward;

public class infoDeleteAction implements Action {

	@Override
	public ActionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("Member_id");
		String pass = (String)request.getParameter("pass");
		
		infoDeleteService service = new infoDeleteService();
		int result = service.checkPass(id,pass);
		if(result > 0)
		{
			session.invalidate();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>"); 
			out.println("alert('삭제완료')"); 
			out.println("location='index.jsp'");
			out.println("</script>");
			out.flush();
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>"); 
			out.println("alert('비밀번호 오류... 다시 확인바랍니다')"); 
			out.println("location='deleteInfo.if'");
			out.println("</script>");
			out.flush();

		}
		return null;
	}

}

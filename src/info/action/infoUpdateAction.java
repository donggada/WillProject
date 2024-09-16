package info.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.svc.infoListService;
import info.svc.infoUpdateService;
import info.vo.ActionForward;
import info.vo.ListBean;

public class infoUpdateAction implements Action {

	@Override
	public ActionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String name = (String)request.getParameter("name");
		String age = (String)request.getParameter("age");
		String tel = (String)request.getParameter("tel");
		String pass = (String)request.getParameter("pass");
		String license = (String)request.getParameter("license");
		String smoke = (String)request.getParameter("smoke");
		String pet = (String)request.getParameter("pet");
		String baby = (String)request.getParameter("baby");
		
		String id = (String)session.getAttribute("Member_id");
		
		ListBean lb = new ListBean();
		lb.setId(id);
		lb.setName(name);
		lb.setAge(age);
		lb.setTel(tel);
		lb.setPass(pass);
		lb.setLicense(license);
		lb.setSmoke(smoke);
		lb.setPet(pet);
		lb.setBaby(baby);
		
		infoUpdateService service = new infoUpdateService();
		boolean check = service.updateInfo(lb);
		if(!check)
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>"); 
			out.println("alert('잠시후 다시 시도해 주세요')"); 
			out.println("history.back()");
			out.println("</script>");
			out.flush();
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>"); 
			out.println("alert('수정완료')"); 
			out.println("location='MemberInfo.if'");
			out.println("</script>");
			out.flush();
		}
		return null;
	}

}

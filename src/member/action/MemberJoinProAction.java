package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.svc.MemberJoinProService;
import member.vo.ActionForward;
import member.vo.MemberBean;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinProAction");
		ActionForward forward=null;
		
		
		System.out.println(request.getParameter("baby"));
		MemberBean bb=new MemberBean();
		bb.setMember_name(request.getParameter("name"));
		bb.setMember_id(request.getParameter("id"));
		bb.setMember_pass(request.getParameter("pass"));
		bb.setMember_email(request.getParameter("email")+"@"+request.getParameter("email1"));
		bb.setMember_age(request.getParameter("age"));
		bb.setMember_gender(request.getParameter("gender"));
		bb.setMember_tel(request.getParameter("tel"));
		bb.setMember_adress(request.getParameter("email"));
		bb.setMember_license(request.getParameter("license"));
		bb.setMember_smoke(request.getParameter("smoke"));
		bb.setMember_pet(request.getParameter("pet"));
		bb.setMember_boby(request.getParameter("baby"));
		
		MemberJoinProService mjps=new MemberJoinProService();
		
		int checkResult=mjps.dupCheckMember(bb.getMember_id());
		
		if(checkResult==0) {
			
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>"); 
			out.println("alert('아이디중복!')"); 
			out.println("history.back()");
			out.println("</script>"); 			
						
		} else if(checkResult==1) {
		
			
			boolean insertsuccess=mjps.joinMemer(bb);
			
			if(insertsuccess) {
				forward=new ActionForward();
				forward.setPath("Member/Member_Login.jsp");
				forward.setRedirect(false);
				
			}else {
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out1 = response.getWriter(); 
				out1.println("<script>"); 
				out1.println("alert('회원가입 실패!')"); 
				out1.println("history.back()");
				out1.println("</script>"); 			
			}
			
		}
		
		
		return forward;
	}

}

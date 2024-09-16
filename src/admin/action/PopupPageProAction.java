package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import admin.svc.PopPageService;
import member.action.Action;
import member.vo.ActionForward;

public class PopupPageProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PopPageService pps=new PopPageService();
		JSONArray PopPage=pps.CallPage();

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(PopPage); 
		
		return null;
	}

}

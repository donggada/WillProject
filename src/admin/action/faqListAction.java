package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.svc.DetailCarListService;
import member.action.Action;
import member.vo.ActionForward;

public class faqListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		JSONArray DetailCarList=null;
		int car_id=Integer.parseInt(request.getParameter("car_id"));
		System.out.println("DetailCarListAction");
		
		DetailCarListService dcls=new DetailCarListService();
		DetailCarList=dcls.DetailCarList(car_id);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(DetailCarList); 
				
		
		return forward;
	} 

}

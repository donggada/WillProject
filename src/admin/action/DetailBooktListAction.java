package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.svc.DetailBookListService;
import admin.svc.DetailCarListService;
import member.action.Action;
import member.vo.ActionForward;

public class DetailBooktListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		JSONArray DetailBookList=null;
		int book_num=Integer.parseInt(request.getParameter("book_num"));
		
		DetailBookListService dcls=new DetailBookListService();
		DetailBookList=dcls.DetailBookList(book_num);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(DetailBookList); 
				
		
		return forward;
	} 

}

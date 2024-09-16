package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.CarListService;
import admin.svc.MemberListService;
import admin.vo.CarBean;
import member.action.Action;
import member.vo.ActionForward;
import member.vo.MemberBean;
import qna.vo.pageinfo;

public class CarListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		int page = 1; 
		int limit = 10;
		String taget="car_id";
		String table="car";
		//String taget=request.getParameter("taget");
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")); 
		}
		
		
		
		//정렬기준 추가
				int lineup=0;
				String line=null;
				if(request.getParameter("lineup")!=null) {
					lineup = Integer.parseInt(request.getParameter("lineup"));	
				}
				
				if(lineup==0) {
					line="desc";
				}else {
					line="asc";
				}
				//정렬항목 추가
				String targetup=null;
				if(request.getParameter("target")!=null) {
					targetup=request.getParameter("target");	
				}
			
		
		
		
		CarListService CarListService = new CarListService();
		
		
		int listCount = CarListService.getListCount(taget,table);
		ArrayList<CarBean> CarList =null;
		
		if(targetup==null) {
			CarList = CarListService.getArticleList(page, limit);
		}else {
			CarList = CarListService.getArticleListlineup(page, limit, line, targetup);
		}
		
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		
		
		int startPage = ((int)((double)page / 10 + 0.9) - 1) * 10 + 1;
		
		
		int endPage = startPage + 10 - 1;
		
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		pageinfo pageInfo = new pageinfo(page, maxPage, startPage, endPage, listCount);
		
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articlelist", CarList);
		request.setAttribute("lineup", lineup);//정렬상태 전달
		
		forward = new ActionForward();
		forward.setPath("/Admin/AdminCarList.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

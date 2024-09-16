package book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.svc.CarListService;
import book.vo.ActionForward;
import book.vo.CarBean;
import book.vo.PageInfo;


public class CarListCountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//차량 목록 출력하는 ActionForward
				ActionForward forward = null;
				
				int page = 1;
				int limit = 10;
				
				if(request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}
				
				CarListService carListService = new CarListService();
				
				int listCount = carListService.getListCount();
				
				ArrayList<CarBean> articleList = carListService.getCarList(page,limit);
				
				int maxPage = (int)((double)listCount / limit +0.95);
				int startPage = ((int)((double)page/10+0.9)-1)*10+1;
				int endPage = startPage+10-1;
				
				if(endPage>maxPage) {
					endPage = maxPage;
				}
				
				PageInfo pageInfo = new PageInfo(page,maxPage,startPage,endPage,listCount);
				
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("articleList", articleList);
				
				forward = new ActionForward();
				forward.setPath("/carIntro/carIntro.jsp");
				
				return forward;
	}

}

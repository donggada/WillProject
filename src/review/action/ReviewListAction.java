package review.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.svc.ReviewListService;
import review.vo.ActionForward;
import review.vo.PageInfo;
import review.vo.ReviewBean;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//리뷰 목록 출력하는 ActionForward
		ActionForward forward = null;
		
		int page = 1;
		int limit = 3;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ReviewListService reviewListService = new ReviewListService();
		
		int listCount = reviewListService.getListCount();
		
		ArrayList<ReviewBean> articleList = reviewListService.getArticleList(page,limit);
		
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
		forward.setPath("/review/reviewList.jsp");
		
		return forward;
	}

}

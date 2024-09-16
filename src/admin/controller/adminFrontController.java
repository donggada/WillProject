
package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.AdminPageAction;
import admin.action.CarListAction;
import admin.action.DetailBooktListAction;
import admin.action.DetailCarListAction;
import admin.action.GraphProAction;
import admin.action.InsertCarAction;
import admin.action.MemberDeleteProAction;
import admin.action.MemberListAction;
import admin.action.MemberModifyAction;
import admin.action.MemberModifyProAction;
import admin.action.MemberSearchListAction;
import admin.action.PopUpPageOffAction;
import admin.action.PopUpPageOnAction;
import admin.action.PopupPageProAction;
import admin.action.PopupPageUploadAction;
import admin.action.QnABoardAction;
import admin.action.ReviewListAction;
import admin.action.SalesChartAction;
import admin.action.SelectCarListAction;
import admin.action.SelectMemberListAction;
import admin.action.SellModifyAction;
import admin.action.SellModifyProAction;
import admin.action.faqListAction;
import admin.action.reviewDeleteProAction;
import admin.action.sellingListAction;
import admin.action.sellingListSearchAction;
import admin.action.sellingListateAction;
import member.action.Action;

import member.vo.ActionForward;


@WebServlet("*.ad")
public class adminFrontController extends HttpServlet {
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("adminFrontController");
		request.setCharacterEncoding("UTF-8");
		String command=request.getServletPath();
		System.out.println(command);
		Action action=null;
		ActionForward forward=null;
		
		if(command.equals("/adminpage.ad")) { //회원가입 화면 이동 
			action=new AdminPageAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MemberList.ad")) {
			action=new MemberListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else if (command.equals("/CarList.ad")) {
			action=new CarListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/GraphPro.ad")) {
			action=new GraphProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/QnABoard.ad")) {
			action=new QnABoardAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/PopupPage.ad")) {
			forward=new ActionForward();
			forward.setPath("/Admin/PoP-UpPage.jsp");
			
		}else if(command.equals("/PopupPageOn.ad")) {
			action=new PopUpPageOnAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/PopupPageOff.ad")) {
			action=new PopUpPageOffAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PopupPageUpload.ad")) {
			action=new PopupPageUploadAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SalesChart.ad")) {
			action=new SalesChartAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CarSelectList.ad")) {
			action=new SelectCarListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Admin/DetailCarInfo.ad")) {
			action=new DetailCarListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberSelectList.ad")) {
			action=new SelectMemberListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/Pop/PopupPagePro.ad")) {
			action=new PopupPageProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Admin/insertCar.ad")) {
			action=new InsertCarAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/insertCarFrom.ad")) {
			forward=new ActionForward();
			forward.setPath("/Admin/InsertCar.jsp");
		}
		
		
		
	
		
		
		else if(command.equals("/mmmodify.ad")) {
			action=new MemberModifyAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		else if(command.equals("/mmmodifypro.ad")) { //회원수정
					action=new MemberModifyProAction();
					try {
						forward=action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
		
		
		
		
		else if(command.equals("/mmdelete.ad")) { // 회원삭제
			action=new MemberDeleteProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	
		else if(command.equals("/sellinglist.ad")) { // 매출현황
			action=new sellingListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(command.equals("/ReviewList.ad")) { //리뷰글 목록
			action = new ReviewListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
		else if(command.equals("/reviewdelete.ad")) { //리뷰글 삭제
			action = new reviewDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		

		else if(command.equals("/mmlistSearch.ad")) { //회원조건검색
			action = new MemberSearchListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
	
		
		
		else if(command.equals("/sellingSearch.ad")) { //매출조건검색
			action = new sellingListSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		

		
		else if(command.equals("/sellinglist2.ad")) { //매출상태조건검색
			action = new sellingListateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		else if(command.equals("/sellmodify.ad")) { //매출상태수정
			action = new SellModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
		else if(command.equals("/sellmodifypro.ad")) { //매출상태수정2
			action = new SellModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		else if(command.equals("/Admin/DetailBooktInfo.ad")) { //매출상세
			action = new DetailBooktListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	
		
		
		
//		else if(command.equals("/faqadminlist.ad")) { //faq리스트
//			action = new faqListAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		
//		}
		
		
		
		if(forward!=null) {
			
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	
	}

}

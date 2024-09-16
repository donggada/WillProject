package faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.action.action;
import faq.action.faqBoardDeleteProAction;
import faq.action.faqBoardListaction;
import faq.action.faqBoardModifyAction;
import faq.action.faqBoardModifyProAction;
import faq.action.faqBoardSearchAction;
import faq.action.faqBoardSearchAction2;
import faq.action.faqBoardTagSearchAction;
import faq.action.faqBoardTagSearchAction2;
import faq.action.faqBoardadminListaction;
import faq.action.faqWriteProAction;
import faq.vo.actionForward;







/**
 * Servlet implementation class boardFrontConttoller2
 */
@WebServlet("*.fbo")
public class faqBoardFrontConttoller extends HttpServlet {

	
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		String commend=request.getServletPath();
//		System.out.println(commend);
		
		
		
		action action=null;
		actionForward forward=null;
		
		if(commend.equals("/qnawrite.bo")) {
			forward = new actionForward();
			forward.setPath("/FAQ/FAQ_write.jsp");
			
		}
		else if(commend.equals("/faqlist.fbo")) {
			action =new faqBoardListaction();
			try {
				forward = action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		else if(commend.equals("/qnaSearchPro.fbo")) {
			action = new faqBoardSearchAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		else if(commend.equals("/faqSearchPro.fbo")) {
			action = new faqBoardSearchAction2();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		else if(commend.equals("/faqtag.fbo")) {
			action = new faqBoardTagSearchAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/faqtag1.fbo")) {
			action = new faqBoardTagSearchAction2();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		else if(commend.equals("/faqwritepro.fbo")) {
			action = new faqWriteProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/faqwriteform.fbo")) {
			forward = new actionForward();
			forward.setPath("/FAQ/faq_write.jsp");
			
		}
		
		
		else if(commend.equals("/faqadminlist.fbo")) {
			action = new faqBoardadminListaction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		
		else if(commend.equals("/faqdelete.fbo")) {
			action = new faqBoardDeleteProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		else if(commend.equals("/faqmodifyform.fbo")) {
			action = new faqBoardModifyAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/faqmodifypro.fbo")) {
			action = new faqBoardModifyProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		
		
		
		
		
//		
//		else if(commend.equals("/qnaBoardReplyForm.bo")) {
//			action = new qnaBoardReplyFormAction();
//
//			try {
//				 forward=action.exectute(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
//		

		

		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
		
		//----------------------------------------------
		
		
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}

	
	
}

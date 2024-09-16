package qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.action.action;
import qna.action.qnaBoardAdminListaction;
import qna.action.qnaBoardAdminListaction2;
import qna.action.qnaBoardDeleteProAction;
import qna.action.qnaBoardDetailAction;
import qna.action.qnaBoardListaction;
import qna.action.qnaBoardModifyAction;
import qna.action.qnaBoardModifyProAction;
import qna.action.qnaBoardReplyProAction;
import qna.action.qnawriteproaction;
import qna.vo.actionForward;



/**
 * Servlet implementation class boardFrontConttoller2
 */
@WebServlet("*.bo")
public class qnaboardFrontController extends HttpServlet {

	
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		String commend=request.getServletPath();
//		System.out.println(commend);
		
		
		
		action action=null;
		actionForward forward=null;
		
		if(commend.equals("/qnawrite.bo")) {
			forward = new actionForward();
			forward.setPath("/QnA/qna_write.jsp");
			
		}
		else if(commend.equals("/qnawritepro.bo")) {
			action =new qnawriteproaction();
			try {
				forward = action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(commend.equals("/qnaBoardlist.bo")) {
			action = new qnaBoardListaction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		else if(commend.equals("/qnaBoardDetail.bo")) {
			action = new qnaBoardDetailAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/qnaBoardReplyPro.bo")) {
			action = new qnaBoardReplyProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/qnaboardcheck.bo")) {
			forward = new actionForward();
			forward.setPath("/QnA/qna_check.jsp");
			
		}
		
		
		else if(commend.equals("/qnawritemodifyform.bo")) {
			action = new qnaBoardModifyAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		else if(commend.equals("/qnaboardmodifypro.bo")) {
			action = new qnaBoardModifyProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else if(commend.equals("/qnaboardfiledowun.bo")) {
			
			forward = new actionForward();
			forward.setPath("/QnA/file_down.jsp");
					
					
				}
		
		else if(commend.equals("/qnaBoardDelete.bo")) {
			action = new qnaBoardDeleteProAction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else if(commend.equals("/qnaBoardDeleteform.bo")) {
			forward = new actionForward();
			forward.setPath("/QnA/qna_Delete.jsp");
			
		}
		
	
		else if(commend.equals("/qnaadminlist.bo")) {
			action = new qnaBoardAdminListaction();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else if(commend.equals("/qnaadminlist2.bo")) {
			action = new qnaBoardAdminListaction2();

			try {
				 forward=action.exectute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
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

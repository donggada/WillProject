package book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import book.action.Action;
import book.action.BookListAction;
import book.action.BookPro2Action;
import book.action.BookPro3Action;
import book.action.BookProAction;
import book.action.CarListAction;
import book.action.ChatBotAction;
import book.action.CoronaDataParsingAction;
import book.vo.ActionForward;

@WebServlet("*.bk")

public class BookFrontController extends HttpServlet {

	@ResponseWrapper
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		Action action = null;
		ActionForward forward = null;

		command = command.substring(command.lastIndexOf("/"), command.length());

		if (command.equals("/BookForm.bk")) {
			forward = new ActionForward();
			forward.setPath("/BookForm.jsp");

		} else if (command.equals("/BookForm2.bk")) {

			action = new CarListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		} else if (command.equals("/BookPro.bk")) {

			action = new BookProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (command.equals("/BookPro2.bk")) {
			action = new BookPro2Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/BookPro3.bk")) {
			action = new BookPro3Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} else if (command.equals("/BookList.bk")) {

			action = new BookListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/chatBotAI.bk")) {
			action = new ChatBotAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/coronaData.bk")) {
			action = new CoronaDataParsingAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // coronaData.bk
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}

package info.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.action.Action;
import info.action.infoDeleteAction;
import info.vo.ActionForward;
import info.action.infoListAction;
import info.action.infoUpdateAction;


@WebServlet("*.if")
public class myPageFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		Action action = null;
		ActionForward forward = null;

		command = command.substring(command.lastIndexOf("/"), command.length());

		if (command.equals("/MemberInfo.if")) {
			action = new infoListAction();
			try 
			{
				forward = action.exectute(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(command.equals("/UpdateInfo.if"))
		{
			action = new infoUpdateAction();
			try 
			{
				forward = action.exectute(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(command.equals("/deleteInfo.if"))
		{
			forward = new ActionForward();
			
			forward.setPath("myPage/deleteInfo.jsp");
		}
		else if(command.equals("/deleteInfoPro.if"))
		{
			action = new infoDeleteAction();
			try 
			{
				forward = action.exectute(request, response);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		if (forward != null) 
		{
			if (forward.isRedirect()) 
			{
				response.sendRedirect(forward.getPath());
			} 
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
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

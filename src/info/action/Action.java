package info.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.vo.ActionForward;


public interface Action {
	//action.execute(request,response);
	//클라이언트의 요청이 들어올 때 서로 다른 클래스들에 대한 요청이므로 각 액션 클래스들이 구현해야하는 메서드를 곹옹된 형태로 정의하기위해 다형성을 활용할 수 있도록 action 인터페이스를 설계
	//각 요청을 받아들일 메서드를 통해 요청과 응답객체를 전달 받고 포워딩정보를 저장하기 위한 액션 포워드 객체를 리턴하도록 정의
	//액션 인터페이스를 상속받아 구현하도록 
	
	ActionForward exectute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
}

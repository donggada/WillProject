package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.InsertCarService;
import book.vo.CarBean;
import book.vo.CarBean.CAR_TYPE;
import member.action.Action;
import member.vo.ActionForward;

public class InsertCarAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		boolean isinsertcar=false;
		System.out.println(request.getParameter("car_is_auto"));
		System.out.println(request.getParameter("car_is_navi")+"navi");
		System.out.println(request.getParameter("car_is_pet"));
		System.out.println(request.getParameter("car_is_smoke"));
		System.out.println(request.getParameter("car_type"));
		System.out.println(request.getParameter("car_maker"));
		System.out.println(request.getParameter("car_name"));
		System.out.println(request.getParameter("car_people_max"));
		System.out.println(request.getParameter("car_year"));
		System.out.println(request.getParameter("car_oil"));
		System.out.println(request.getParameter("car_license_type"));
		System.out.println(request.getParameter("car_cc"));
		System.out.println(request.getParameter("car_price_normal"));
		System.out.println(request.getParameter("car_price_sale"));
		System.out.println(request.getParameter("car_function"));
		System.out.println(request.getParameter("car_color"));
		System.out.println(request.getParameter("car_num"));
		CarBean cb=new CarBean();
		//cb.setCar_id(request.getParameter("car_id"));
		cb.setCar_is_auto(Integer.parseInt(request.getParameter("car_is_auto")) == 0 ? false : true);
		cb.setCar_is_navi(Integer.parseInt(request.getParameter("car_is_navi")) == 0 ? false : true);
		cb.setCar_is_pet(Integer.parseInt(request.getParameter("car_is_pet"))== 0 ? false : true);
		//cb.setCar_is_rent(Integer.parseInt(request.getParameter("car_is_rent")) == 0 ? false : true);
		cb.setCar_is_smoke(Integer.parseInt(request.getParameter("car_is_smoke"))== 0 ? false : true);
		
		//cb.setCar_is_rent(request.getParameter("car_is_rent"));
		cb.setCar_type(Integer.parseInt(request.getParameter("car_type")));
		cb.setCar_maker(request.getParameter("car_maker"));
		cb.setCar_name(request.getParameter("car_name"));
		cb.setCar_people_max(Integer.parseInt(request.getParameter("car_people_max")));
		//cb.setCar_people_max(Integer.parseInt(request.getParameter("car_open")));
		//cb.setCar_people_possible(Integer.parseInt(request.getParameter("car_people_possible")));
		cb.setCar_year(Integer.parseInt(request.getParameter("car_year")));
		cb.setCar_oil(Integer.parseInt(request.getParameter("car_oil")));
		//cb.setCar_is_auto(Integer.parseInt(request.getParameter("car_is_auto")));
		cb.setCar_license_type(Integer.parseInt(request.getParameter("car_license_type")));
		//cb.setCar_license_year(Integer.parseInt(request.getParameter("car_license_year")));
		cb.setCar_cc(Integer.parseInt(request.getParameter("car_cc")));
		cb.setCar_price_normal(Integer.parseInt(request.getParameter("car_price_normal")));
		cb.setCar_price_sale(Integer.parseInt(request.getParameter("car_price_sale")));
		cb.setCar_function(Integer.parseInt(request.getParameter("car_function")));
		//cb.setCar_trunk(Integer.parseInt(request.getParameter("car_trunk")));
		cb.setCar_color(request.getParameter("car_color"));
		//cb.setCar_is_navi(Integer.parseInt(request.getParameter("car_is_navi")));
		//cb.setCar_is_pet(Integer.parseInt(request.getParameter("car_is_pet")));
		//cb.setCar_is_smoke(Integer.parseInt(request.getParameter("car_is_smoke")));
		cb.setCar_num(request.getParameter("car_num"));
		
		
		
		InsertCarService ic=new InsertCarService();
		isinsertcar=ic.Insertcar(cb);
		
		if(isinsertcar) {
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out1 = response.getWriter(); 
			out1.println("<script>"); 
			out1.println("alert('차량등록 성공!')"); 
			out1.println("</script>"); 			
			forward=new ActionForward();
			forward.setPath("/Admin/InsertCar.jsp");
		}else {
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out1 = response.getWriter(); 
			out1.println("<script>"); 
			out1.println("alert('차량등록 실패!')"); 
			out1.println("history.back()");
			out1.println("</script>"); 			
		}
		
		
		
		return forward;
	}

}

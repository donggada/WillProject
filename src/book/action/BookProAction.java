package book.action;

import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.svc.BookProService;
import book.vo.ActionForward;
import book.vo.BookBean;

public class BookProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String selCarType = request.getParameter("SelCarType");
		
		ActionForward forward = null;

		BookBean bb = new BookBean();
		Date date1 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pickup")).getTime());
		Date date2 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end")).getTime());

		int rentday = (int) ((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000));

		String id = request.getParameter("member_id");
//		String snsid = request.getParameter("snsid");

//		String SelCarType = request.getParameter("SelCar"); 
//		

//		BookBean bb = (BookBean)request.getAttribute("bookList");

//		System.out.println(SelCarType);
		bb.setBook_num(Integer.parseInt(request.getParameter("book_num")));
		bb.setMember_id(id);
		bb.setPickup_date(date1);
		bb.setEnd_date(date2);
		bb.setCar_id(request.getParameter("car_id"));
		bb.setBook_state(1);
		bb.setBook_price(Integer.parseInt((request.getParameter("rentprice"))));

		BookProService bps = new BookProService();
		boolean isWriteSuccess = bps.registBook(bb);

		if (isWriteSuccess) {
			System.out.println(bb.getBook_num());

			BookBean bookList = bps.selectBookNum(bb);
			request.setAttribute("bookList", bookList);
			forward = new ActionForward();
			forward.setPath("book/BookForm3.jsp");

		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			request.setAttribute("carList", bb);
			
			out.println("<script>");
			out.println("alert('결재 실패!');");
			out.println("location.href='BookForm2.bk?car_id="+bb.getCar_id()+"&pickup_date="+bb.getPickup_date()+"&end_date="+bb.getEnd_date()+"&rentprice="+bb.getBook_price()+"&SelCar="+selCarType+"&rentday="+rentday+"&member_id="+bb.getMember_id()+"&book_num="+bb.getBook_num()+"'");
			out.println("</script>");
			out.println("<%request.setAttribute(\"carList\", bb);\r\n" + "%>");
		}

		return forward;
	}

}

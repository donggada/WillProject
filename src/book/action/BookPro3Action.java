package book.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.vo.ActionForward;
import book.vo.BookBean;

public class BookPro3Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		BookBean bb = new BookBean();
		Date date1 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pickup")).getTime());
		Date date2 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end")).getTime());

//		long rentday = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
		String id = request.getParameter("member_id");
		int rentprice = Integer.parseInt(request.getParameter("rentprice"));
//		String snsid = request.getParameter("snsid");

//		경차(0),
//		소형(1),
//		중형(2),
//		준대형(3),
//		대형(4),
//		승합(5),
//		SUVㅣRV(6),
//		전기차(7),
//		수입차(8);
		Date date3 = new Date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("pickup")).getTime());

		System.out.println("리퀘스트로 받은거 : " + request.getParameter("pickup"));
		String SelCarType = request.getParameter("SelCarType");
		System.out.println("액	션");
		System.out.println(SelCarType);
		System.out.println(date3);
		String book1 = null;
		String book2 = null;
		String book3 = null;

		String BookPickupDate = request.getParameter("pickup");
		String BookEndDate = request.getParameter("end");

		book2 = BookPickupDate.replace("-", "");
		book2 = book2.substring(book2.length() - 6, book2.length());

//		book3 = BookEndDate.replace("-","");
//		book3 = book3.substring(book3.length()-2, book3.length());

		if (SelCarType.equals("경차")) {
			book1 = "1";
		} else if (SelCarType.equals("소형")) {
			book1 = "2";
		} else if (SelCarType.equals("중형")) {
			book1 = "3";
		} else if (SelCarType.equals("준대형")) {
			book1 = "4";
		} else if (SelCarType.equals("대형")) {
			book1 = "5";
		} else if (SelCarType.equals("승합")) {
			book1 = "6";
		} else if (SelCarType.equals("SUVㅣRV")) {
			book1 = "7";
		} else if (SelCarType.equals("전기차")) {
			book1 = "8";
		} else {
			book1 = "9";
		}

		System.out.println(book1);
		System.out.println(book2);

		String payType = request.getParameter("payType");
		System.out.println(payType);
//		System.out.println(date3);
//		String BookNumFin = book1 + book2 +book3;

		String FinalBookNum = (book1 + book2 + "00");
		System.out.println(FinalBookNum);

		bb.setBook_num(Integer.parseInt(FinalBookNum));
		bb.setMember_id(id);
		bb.setPickup_date(date1);
		bb.setEnd_date(date2);
		bb.setCar_id(request.getParameter("car_id"));
		bb.setBook_state(1);
		bb.setBook_price(rentprice);

		request.setAttribute("bookList", bb);
		forward = new ActionForward();

		if (payType.equals("cash")) {
			forward.setPath("payCheck/payment_vbank.jsp"); // 무통장입금 페이x`지로 이동
		} else if (payType.equals("card")) {
			forward.setPath("payCheck/payment_card.jsp");
		}
		return forward;
	}

}

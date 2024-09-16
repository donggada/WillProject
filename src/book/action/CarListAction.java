package book.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.svc.BookListService;
import book.svc.BookProService;
import book.svc.CarListService;
import book.vo.ActionForward;
import book.vo.BookBean;
import book.vo.CarBean;

public class CarListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		BookListService bls = new BookListService();
		ArrayList<BookBean> bookList = null;
		bookList = bls.getBookList();
		request.setAttribute("bookList", bookList);

		String pet = request.getParameter("option_pet");
		String baby = request.getParameter("option_baby");
		String smoke = request.getParameter("option_smoke");

		boolean pet2;
		boolean baby2;
		boolean smoke2;

		if (pet == null) {
			pet2 = false;
		} else {
			pet2 = true;
		}

		
		if (baby == null) {
			baby2 = false;
		} else {
			baby2 = true;
		}
		

		if (smoke == null) {
			smoke2 = false;
		} else {
			smoke2 = true;
		}

		
		String pickup = request.getParameter("pickup_date");
		String end = request.getParameter("end_date");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date pickDate = sdf.parse(pickup);
		Date returnDate = sdf.parse(end);

		int rentday = (int) ((returnDate.getTime() - pickDate.getTime()) / (24 * 60 * 60 * 1000));

		System.out.println(rentday);

		Map<String, Integer> idmap = new HashMap<String, Integer>();

		for (BookBean b : bookList) {
			if (pickDate.before(b.getEnd_date()) && returnDate.after(b.getPickup_date())) {
				idmap.put(b.getCar_id(), 1);
			}
		}

		CarListService carListService20 = new CarListService();
		LinkedList<CarBean> carList = null;
		carList = carListService20.getCarLinkedList(smoke2,pet2,baby2);

		Iterator<CarBean> iter = carList.iterator();

		while (iter.hasNext()) {
			CarBean cb = iter.next();
			String temp = "" + cb.getCar_id();
			if (idmap.containsKey(temp)) {
				iter.remove();
			}
		}

		request.setAttribute("rentday", rentday);
		request.setAttribute("carList", carList);
		forward = new ActionForward();
		forward.setPath("/book/BookForm2.jsp");
		return forward;
	}
}
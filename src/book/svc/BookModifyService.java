package book.svc;

import static book.db.JdbcUtil.*;



import java.sql.Connection;


import book.dao.BookDAO;
import book.vo.BookBean;



public class BookModifyService {

	
	public boolean mmmodify(BookBean bb) {
		boolean result=false;
		System.out.println("mmmodify");
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result = bookDAO.selectmodify(bb);
	
		close(con);

		return result;
	}
	
}

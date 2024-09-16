package book.svc;

import static book.db.JdbcUtil.getConnection;
import static book.db.JdbcUtil.close;
import static book.db.JdbcUtil.close;
import static book.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.BookBean;

import book.dao.BookDAO;
import book.vo.BookBean;

public class BookListModifyService {

	public ArrayList<BookBean> getBookList() {

		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		// MemberDAO 클래스의 selectMemberList() 메서드를 호출하여
		// 회원 목록 조회 요청 작업 수행
		// => 파라미터 : 없음, 리턴타입 : ArrayList<MemberBean>
		ArrayList<BookBean> memberlist = bookDAO.selectBookList();

		close(con);

		return memberlist;
	}

	public ArrayList<BookBean> getBookList(String orderTarget, String orderType) {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectBookList(orderTarget, orderType);

		close(con);

		return booklist;

	}
	
	
	public ArrayList<BookBean> getBookList2(String str1, String str2) {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectBookListadmin(str1, str2);

		close(con);

		return booklist;

	}
	
	
	public int getBooksum(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListsum(str1, str2);

		close(con);

		return result;

	}
	
	
	public int getBookcount(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListcount(str1, str2);

		close(con);

		return result;

	}
	
	
	public int getBookc(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListp1(str1, str2);

		close(con);

		return result;

	}
	public int getBookc2(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListp2(str1, str2);

		close(con);

		return result;

	}

	public int getBookf(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListf(str1, str2);

		close(con);


		return result;

	}
	
	public int getBookfs(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListfs(str1, str2);

		close(con);

		return result;

	}
	
	
	public int getBookfs2(String str1, String str2) {
		int result=0;
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		result= bookDAO.selectBookListfs2(str1, str2);

		close(con);

		return result;

	}

	public ArrayList<BookBean> getmmcount() {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectcountsum();

		close(con);

		return booklist;
	}
	
	public ArrayList<BookBean> getBooksearchList(String str1, String str2) {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectBooksearchList(str1, str2);

		close(con);

		return booklist;

	}

	public ArrayList<BookBean> getBookstateList(String state) {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectBookstateList(state);

		close(con);

		return booklist;
	}

	public ArrayList<BookBean> getBookstateList() {
		Connection con = getConnection();

		BookDAO bookDAO = BookDAO.getInstance();

		bookDAO.setConnection(con);

		ArrayList<BookBean> booklist = bookDAO.selectBookstateList();

		close(con);

		return booklist;
	}
	
}

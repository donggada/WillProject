package book.dao;

import static book.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import book.dao.BookDAO;
import book.vo.BookBean;

public class BookDAO {

	private BookDAO() {
	}

	private static BookDAO instance = new BookDAO();

	public static final BookDAO getInstance() {
		// TODO Auto-generated method stub.

		if (instance == null) {
			instance = new BookDAO();
		}

		return instance;
	}

	Connection con;

	public void setConnection(Connection con) {
		this.con = con;

	}

	public int insertArticle(BookBean article) {
		// TODO Auto-generated method stub

		int insertCount = 0; // INSERT 작업 결과를 저장할 변수

		PreparedStatement pstmt = null;
		ResultSet rs = null;

	
			if(selectBookNum(article) !=null) {
				return 0;
			}
			
			
		try {

			String sql = "select MAX(book_num) FROM book WHERE book_num LIKE ?";
			pstmt = con.prepareStatement(sql);

			String originalNum = article.getBook_num() + "";
			String frontNum = originalNum.substring(0, 6);
			int finalNum = 0;

			pstmt.setString(1, frontNum + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					finalNum = Integer.parseInt(originalNum);
					System.out.println("들어갈 넘버값 : " + finalNum);
				} else {
					finalNum = rs.getInt(1) + 1;
					System.out.println("들어갈 넘버값 : " + finalNum);
				}
			}

			sql = "insert into book(book_num, car_id, pickup_date, end_date,member_id, book_price, book_state, book_date) values(?,?,?,?,?,?,?,now()) ";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, finalNum);
			pstmt.setString(2, article.getCar_id());
			pstmt.setDate(3, article.getPickup_date()); // 수령
			pstmt.setDate(4, article.getEnd_date()); // 반납
			pstmt.setString(5, article.getMember_id());
			pstmt.setInt(6, article.getBook_price());
			pstmt.setInt(7, article.getBook_state());
			
			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// PreparedStatement, ResultSet 객체 반환
			close(rs); // JdbcUtil.close(rs)
			close(pstmt); // JdbcUtil.close(rs)
		}

		return insertCount;
	}

	// 회원 목록 조회 작업을 위한 selectMemberList() 메서드 정의
	public ArrayList<BookBean> selectBookList() {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public ArrayList<BookBean> selectBookList(String orderTarget, String orderType) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM member ORDER BY " + orderTarget + " " + orderType;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	// 삭제

	public int deleteArticle(int book_num) {
		// TODO Auto-generated method stub

		int insertCount = 0; // INSERT 작업 결과를 저장할 변수

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "delete from book where book_num = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, book_num);

			rs = pstmt.executeQuery();

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// PreparedStatement, ResultSet 객체 반환
			close(rs); // JdbcUtil.close(rs)
			close(pstmt); // JdbcUtil.close(rs)
		}

		return insertCount;
	}

	// 수정
	public int updateArticle(BookBean bb) {
		// TODO Auto-generated method stub

		int insertCount = 0; // INSERT 작업 결과를 저장할 변수

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//		String sql = "update book set book_date=?,pickup_date=?,end_date=?, car_id=?,book_price=?,insurance=?,book_state=?";

			StringBuffer sql = new StringBuffer();

			sql.append("update book set ");
			sql.append("bbook_date=?,pickup_date=?,end_date=?, ");
			sql.append("car_id=?,book_price=?,insurance=?,book_state=?");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setDate(1, bb.getBook_date());
			pstmt.setDate(2, bb.getPickup_date());
			pstmt.setDate(3, bb.getEnd_date());
			pstmt.setString(4, bb.getCar_id());
			pstmt.setInt(5, bb.getBook_price());
			pstmt.setInt(6, bb.getInsurance());
			pstmt.setInt(6, bb.getBook_state());

			rs = pstmt.executeQuery();

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// PreparedStatement, ResultSet 객체 반환
			close(rs); // JdbcUtil.close(rs)
			close(pstmt); // JdbcUtil.close(rs)
		}

		return insertCount;
	}

	public ArrayList<BookBean> selectBookListadmin(String str1, String str2) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book where book_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public int selectBookListsum(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT SUM(book_price) FROM book where book_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("SUM(book_price)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListcount(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT COUNT(book_price) FROM book where book_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("COUNT(book_price)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListp1(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT ((SUM(book_price)-(SELECT SUM(book_price) FROM book where (book_date > ? -INTERVAL 1 MONTH and book_date < ? )))/(SELECT SUM(book_price) FROM book where (book_date > ? -INTERVAL 1 MONTH and book_date < ? )))*100 as score FROM book where booK_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1);
			pstmt.setString(2, str1);
			pstmt.setString(3, str1);
			pstmt.setString(4, str1);
			pstmt.setString(5, str1);
			pstmt.setString(6, str2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("score");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListp2(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT ((count(book_price)-(SELECT count(book_price) FROM book where (book_date > ? -INTERVAL 1 MONTH and book_date < ? )))/(SELECT count(book_price) FROM book where (book_date > ? -INTERVAL 1 MONTH and book_date < ? )))*100 as score FROM book where booK_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1);
			pstmt.setString(2, str1);
			pstmt.setString(3, str1);
			pstmt.setString(4, str1);
			pstmt.setString(5, str1);
			pstmt.setString(6, str2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("score");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListf(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select count(*) as nullcount from book where book_state is null and booK_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("nullcount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListfs(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select sum(book_price) from book where book_state is null and booK_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("sum(book_price)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int selectBookListfs2(String str1, String str2) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select sum(book_price) from book where book_state is null and booK_date between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str1); // 시작레코드번호
			pstmt.setString(2, str2); // 게시글 수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("sum(book_price)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<BookBean> selectcountsum() {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select member_id, count(book_price) as count, sum(book_price) as sum  from book group by member_id;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();

				book.setMember_id(rs.getString("member_id"));
				book.setCount(rs.getInt("count"));
				book.setSum(rs.getInt("sum"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public ArrayList<BookBean> selectBooksearchList(String select, String search) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book where " + select + " like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");

			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public ArrayList<BookBean> selectBookstateList(String state) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book where book_state like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + state + "%");

			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public ArrayList<BookBean> selectBookstateList() {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book where book_state IS NULL";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public BookBean selectBookdetail(int num) {
		BookBean book = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM book where book_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			book = new BookBean();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));
				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));
				book.setBook_state(rs.getInt("insurance"));
				book.setBook_state(rs.getInt("end_date"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectbookList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return book;
	}

	public boolean selectmodify(BookBean bb) {
		boolean result = false;
		System.out.println("selectmodify");
		PreparedStatement pstmt = null;
		try {
			String sql = "update book set book_state=? where book_num=?";
			pstmt = con.prepareStatement(sql);
			System.out.println(bb.getBook_state());
			System.out.println(bb.getBook_num());

			pstmt.setInt(1, bb.getBook_state());
			pstmt.setInt(2, bb.getBook_num());
			int s = pstmt.executeUpdate();
			System.out.println("update 갯수 " + s);
			commit(con);
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update에러");
		} finally {
			close(pstmt);
		}

		return result;

	}
	public BookBean selectBookNum(BookBean bn) {
		
		BookBean bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			String sql = "SELECT * FROM book where pickup_date=? and end_date=? and car_id=?";
	        pstmt = con.prepareStatement(sql);
			
			pstmt.setDate(1, bn.getPickup_date());
			pstmt.setDate(2, bn.getEnd_date());
			pstmt.setString(3, bn.getCar_id());

			rs = pstmt.executeQuery();
	

			if (rs.next()) {
				bookList = new BookBean();
//				Date k = rs.getString(rs.getDate("pickup_date"))
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				bookList.setBook_num(rs.getInt("book_num"));
				bookList.setMember_id(rs.getString("member_id"));
				bookList.setBook_date(rs.getDate("book_date"));
				bookList.setPickup_date(rs.getDate("pickup_date"));
				bookList.setEnd_date(rs.getDate("end_date"));
				bookList.setCar_id(rs.getString("car_id"));
				bookList.setBook_price(rs.getInt("book_price"));
				bookList.setBook_state(rs.getInt("book_state"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}


	public ArrayList<BookBean> selectBookstateListllineup(String line, String targetup) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(targetup);
		System.out.println(line);
		
		try {
			String sql = "SELECT * FROM book order by "+targetup+" "+line;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}

	public ArrayList<BookBean> selectBookstateListlineup(String state, String targetup, String line) {
		ArrayList<BookBean> bookList = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(targetup);
		System.out.println(line);
		System.out.println(state);
		
		try {
			String sql = "SELECT * FROM book where book_state=? order by "+targetup+" "+line;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, state);
			rs = pstmt.executeQuery();

			bookList = new ArrayList<BookBean>();

			while (rs.next()) {
				// 조회된 결과 중 1개 레코드를 MemberBean 객체에 저장 후 ArrayList 에 추가
				BookBean book = new BookBean();
				book.setBook_num(rs.getInt("book_num"));

				book.setMember_id(rs.getString("member_id"));
				book.setBook_date(rs.getDate("book_date"));
				book.setPickup_date(rs.getDate("pickup_date"));
				book.setEnd_date(rs.getDate("end_date"));
				book.setCar_id(rs.getString("car_id"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_state(rs.getInt("book_state"));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMemberList() 오류!");
		} finally {
			close(rs);
			close(pstmt);
		}

		return bookList;
	}
}

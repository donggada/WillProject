package book.svc;

import java.sql.Connection;

import book.dao.BookDAO;
import book.db.JdbcUtil;
import book.vo.BookBean;

public class BookProService {

	public boolean registBook(BookBean bb) {

		// 1. 글쓰기 작업 요청 처리 결과를 저장할 boolean 타입 변수 선언
		boolean isWriteSuccess = false;

		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();

		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BookDAO bookDAO = BookDAO.getInstance();

		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체를 전달(공통)
		bookDAO.setConnection(con);

		// 5. BoardDAO 객체의 XXX 메서드를 호출하여 XXX 작업 수행 및 결과 리턴 받기
		// insertArticle() 메서드를 호출하여 글등록 작업 수행 및 결과 리턴받아 처리
		// => 파라미터 : BoardBean 객체, 리턴값 : int(insertCount)
		int insertCount = bookDAO.insertArticle(bb);

		// 리턴값에 대한 결과 처리
		if (insertCount > 0) { // 작업이 성공했을 경우
			// INSERT 작업이 성공했을 경우 트랜잭션 적용을 위해
			// JdbcUtil 클래스의 commit() 메서드를 호출하여 commit 작업 수행
			JdbcUtil.commit(con);

			// 작업 처리 결과를 성공으로 표시하기 위해 isWriteSuccess 를 true 로 지정
			isWriteSuccess = true;
		} else { // 작업이 실패했을 경우
			// INSERT 작업이 실패했을 경우 트랜잭션 적용 취소를 위해
			// JdbcUtil 클래스의 rollback() 메서드를 호출하여 rollback 작업 수행
			JdbcUtil.rollback(con);
		}

		// 6. JdbcUtil 객체로부터 가져온 Connection 객체를 반환(공통)
		JdbcUtil.close(con);

		return isWriteSuccess;
	}




	public BookBean selectBookNum(BookBean bn) {

		BookBean bookList = null;

		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();

		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BookDAO bookDAO = BookDAO.getInstance();

		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체를 전달(공통)
		bookDAO.setConnection(con);

		bookList = bookDAO.selectBookNum(bn);

		JdbcUtil.close(con);

		return bookList;
	}
}


package review.svc;

import static faq.db.jdbcutil.close;
import static faq.db.jdbcutil.commit;
import static faq.db.jdbcutil.getconnection;
import static review.db.jdbcUtil.*;

import java.sql.Connection;

import faq.dao.faqBoardDAO;
import review.dao.ReviewDAO;
import review.vo.ReviewBean;

public class ReviewDeleteProService {
	
	//작성자 확인 isArticleWriter(review_num, review_pass)
	public boolean isArticleWriter(int review_num, String review_pass) {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		
		isArticleWriter = reviewDAO.isArticleReviewWriter(review_num,review_pass);
		
		close(con);
		return isArticleWriter;
	}

	//리뷰글 삭제 removeArticle(review_num)
	public boolean removeArticle(int review_num) {
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		
		int deleteCount = reviewDAO.deleteArticle(review_num);
		if(deleteCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return isDeleteSuccess;
	}

	public int removeArticleadmin(ReviewBean reviewbean) {
int check = 0;
		
		Connection con=getconnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		
		
		int updatedelete=reviewDAO.delete(reviewbean.getReview_num());
		commit(con);
		
		
		
		
		
		close(con);
		return check;
		
		
	}

}

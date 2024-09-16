package review.dao;

import static review.db.jdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import review.vo.ReviewBean;

public class ReviewDAO {
	private static ReviewDAO instance;
	private ReviewDAO() {}
	public static ReviewDAO getInstance() {
		if(instance == null) {
			instance = new ReviewDAO();
		}
		return instance;
	}
	
	Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	//리뷰글 작성(insertReview)
	public int insertReview(ReviewBean reviewBean) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX(review_num) FROM review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int num = 1;
			if(rs.next()) {
				num = rs.getInt(1)+1;
			}
			
			sql = "INSERT INTO review VALUES(?,?,?,?,?,?,?,?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, reviewBean.getBook_num());
			pstmt.setString(3, reviewBean.getMember_id());
			pstmt.setString(4, reviewBean.getCar_id());
			pstmt.setString(5, reviewBean.getPickup_date());
			pstmt.setString(6, reviewBean.getEnd_date());
			pstmt.setString(7, reviewBean.getReview_subject());
			pstmt.setString(8, reviewBean.getReview_content());
			pstmt.setString(9, reviewBean.getReview_file());
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);
			pstmt.setString(12, reviewBean.getReview_pass());
			
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}
	//전체 리뷰글 수 조회
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT COUNT(review_num) FROM review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
			listCount = rs.getInt(1);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	//전체 리뷰글 조회
	public ArrayList<ReviewBean> selectArticleList(int page, int limit) {
		ArrayList<ReviewBean> articleList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			int startRow = (page-1) *3;
			String sql = "SELECT * FROM review ORDER BY review_num DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			articleList = new ArrayList<ReviewBean>();
			while(rs.next()) {
				ReviewBean article = new ReviewBean();
				article.setReview_num(rs.getInt("review_num"));
				article.setBook_num(rs.getInt("book_num"));
				article.setMember_id(rs.getString("member_id"));
				article.setCar_id(rs.getString("car_id"));
				article.setPickup_date(rs.getString("pickup_date"));
				article.setEnd_date(rs.getString("end_date"));
				
				article.setReview_subject(rs.getString("review_subject"));
				article.setReview_content(rs.getString("review_content"));
				article.setReview_file(rs.getString("review_file"));
				article.setReview_readcount(rs.getInt("review_readcount"));
				article.setReview_recocount(rs.getInt("review_recocount"));
				
				article.setReview_date(rs.getDate("review_date"));
				
				articleList.add(article);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	//리뷰글 조회
	public ReviewBean selectArticle(int review_num) {
		ReviewBean article = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM review WHERE review_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				article = new ReviewBean();
				article.setReview_num(rs.getInt("review_num"));
				article.setBook_num(rs.getInt("book_num"));
				article.setMember_id(rs.getString("member_id"));
				article.setCar_id(rs.getString("car_id"));
				article.setPickup_date(rs.getString("pickup_date"));
				article.setEnd_date(rs.getString("end_date"));
				
				article.setReview_subject(rs.getString("review_subject"));
				article.setReview_content(rs.getString("review_content"));
				article.setReview_file(rs.getString("review_file"));
				article.setReview_readcount(rs.getInt("review_readcount"));
				article.setReview_recocount(rs.getInt("review_recocount"));
				
				article.setReview_date(rs.getDate("review_date"));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return article;
	}
	
	//조회수 올리기
	public int updateReadCount(int review_num) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;		
		try {
			String sql = "UPDATE review SET review_readcount=review_readcount+1 WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			updateCount = pstmt.executeUpdate();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	//추천수 올리기
	public int updateRecoCount(int review_num) {
		int recoSuccess = 0;
		
		PreparedStatement pstmt = null;		
		try {
			String sql = "UPDATE review SET review_recocount=review_recocount+1 WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			recoSuccess = pstmt.executeUpdate();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return recoSuccess;
	}
	//추천수 조회
	public int selectRecoCount(int review_num) {
		
		int updateRecoCount = 0;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT review_recoCount FROM review where review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				updateRecoCount = rs.getInt("review_recoCount");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return updateRecoCount;
	}
	//리뷰 작성자 확인
	public boolean isArticleReviewWriter(int review_num, String review_pass) {
		boolean isArticleWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT review_pass FROM review WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(review_pass.equals(rs.getString("review_pass"))) {
					isArticleWriter = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return isArticleWriter;
	}
	
	//리뷰 수정
	public int updateArticle(ReviewBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE review SET review_subject=?, review_content=?, review_file=? WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getReview_subject());
			pstmt.setString(2, article.getReview_content());
			pstmt.setString(3, article.getReview_file());
			pstmt.setInt(4, article.getReview_num());
			updateCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	//리뷰 삭제
	public int deleteArticle(int review_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM review WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			deleteCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
	
	public int deleteArticle(ReviewBean reviewbean) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM review WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewbean.getReview_num());
			deleteCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
	
	
	public int delete(int review_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM review WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			deleteCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
}

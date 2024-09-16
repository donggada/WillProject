package qna.dao;

import static qna.db.jdbcutil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import qna.dao.qnaBoardDAO;
import qna.vo.qnaBoardbean;

public class qnaBoardDAO {

private static qnaBoardDAO instance; {
		
	}
	
	private qnaBoardDAO() {}
	
	public static final qnaBoardDAO getinstance() {
		if(instance==null) {
			instance=new qnaBoardDAO();
		}
		
		return instance;
	}
	
	Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	public int insertArticle(qnaBoardbean article) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql="select max(qnaBoard_num) from qnaBoard";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			int num = 1;
			
			if(rs.next()) {
				num=rs.getInt(1) + 1;
			}
			
			sql="insert into qnaBoard(qnaBoard_num,qnaBoard_id,qnaBoard_pass,qnaBoard_subject,qnaBoard_content,qnaBoard_file,qnaBoard_re_ref,qnaBoard_re_lev,qnaBoard_re_seq,qnaBoard_readcount,qnaBoard_tag,qnaBoard_reply,qnaBoard_date )"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,now());";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getQnaBoard_id());
			pstmt.setString(3, article.getQnaBoard_pass());
			pstmt.setString(4, article.getQnaBoard_subject());
			pstmt.setString(5, article.getQnaBoard_content());
			pstmt.setString(6, article.getQnaBoard_file());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setString(11, article.getQnaBaord_tag());
			pstmt.setString(12, null);
			
			
			
			insertCount=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("insert에러");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		
		return insertCount;
	}
	
	
	
	public int selectlist(String id) {
		int listcount=0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql="select count(*) from qnaBoard where qnaboard_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listcount=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("qboard selectlist오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		
		
		return listcount;
	}
	
	
	
	public int selectlist2() {
		int listcount=0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql="select count(*) from qnaBoard";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listcount=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("qboard selectlist오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		
		
		return listcount;
	}

	

	public ArrayList<qnaBoardbean> selectarticlelist(int page, int limit) {
		
		ArrayList<qnaBoardbean> list=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			int startrow=(page-1)*4;
			
			
			String sql="select *from qnaBoard order by qnaBoard_re_ref desc, qnaBoard_re_seq asc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit); 
			rs=pstmt.executeQuery();
			
			
			list = new ArrayList<qnaBoardbean>();
			while(rs.next()) {
				qnaBoardbean article = new qnaBoardbean();
				article.setQnaBoard_num(rs.getInt("qnaboard_num"));
				article.setQnaBoard_id(rs.getString("qnaboard_id"));
				article.setQnaBoard_subject(rs.getString("qnaboard_subject"));
				article.setQnaBoard_content(rs.getString("qnaboard_content"));
				article.setQnaBoard_file(rs.getString("qnaboard_file"));
				article.setQnaBoard_re_ref(rs.getInt("qnaboard_re_ref"));
				article.setQnaBoard_re_lev(rs.getInt("qnaboard_re_lev"));
				article.setQnaBoard_re_seq(rs.getInt("qnaboard_re_seq"));
				article.setQnaBoard_readcount(rs.getInt("qnaboard_readcount"));
				article.setQnaBoard_date(rs.getDate("qnaboard_date"));
				article.setQnaBaord_tag(rs.getString("qnaboard_tag"));
				article.setQnaboard_reply(rs.getString("qnaboard_reply"));
	

				list.add(article);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("qboard selectarticlelist오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		return list;
	}
	
	
	
	public qnaBoardbean getcontent(int boardnum) {
		
		qnaBoardbean article=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
	
			String sql="select * from qnaboard where qnaBoard_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnum); 
			rs=pstmt.executeQuery();
			
			
			article = new qnaBoardbean();
			if(rs.next()) {
				article = new qnaBoardbean();
				article.setQnaBoard_num(rs.getInt("qnaBoard_num"));
				article.setQnaBoard_id(rs.getString("qnaboard_id"));
				article.setQnaBoard_subject(rs.getString("qnaboard_subject"));
				article.setQnaBoard_content(rs.getString("qnaboard_content"));
				article.setQnaBoard_file(rs.getString("qnaboard_file"));
				article.setQnaBoard_re_ref(rs.getInt("qnaboard_re_ref"));
				article.setQnaBoard_re_lev(rs.getInt("qnaboard_re_lev"));
				article.setQnaBoard_re_seq(rs.getInt("qnaboard_re_seq"));
				article.setQnaBoard_readcount(rs.getInt("qnaboard_readcount"));
				article.setQnaBoard_date(rs.getDate("qnaboard_date"));
				article.setQnaboard_reply(rs.getString("qnaBoard_reply"));
				article.setQnaBoard_reply_date(rs.getDate("qnaboard_reply_date"));

			}
			
			
			
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("board content오류");
		}finally {
			close(rs); 
			close(pstmt);
		}
		
		
		return article;
	}
	
	
	
	
	
	
	

	
	
	public int updatereadcount(int boardnum) {
		int updatereadcount = 0;
		

		PreparedStatement pstmt = null;
		
		try {
						String sql = "UPDATE qnaboard SET qnaboard_readcount=qnaboard_readcount+1 "
									+ "WHERE qnaboard_num=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, boardnum);
						updatereadcount = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return updatereadcount;
	}
	
	
	
public int reply(qnaBoardbean b) {

	
		int insertCount=0;
		PreparedStatement pstmt = null;
		
		try {
			String Sql="UPDATE qnaboard SET qnaboard_reply=?, qnaboard_reply_date=now()"+" "+"WHERE qnaboard_num=?";
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1, b.getQnaboard_reply());
            pstmt.setInt(2, b.getQnaBoard_num());			
			insertCount=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("답변글쓰기 에러");
		}finally {
			close(pstmt);
		}

		
		return insertCount;
	}



public boolean qnaboardcheck(qnaBoardbean qnaboard) {
//	System.out.println("체크");
	boolean check=false;
	

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {String sql = "select * from qnaboard_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,qnaboard.getQnaBoard_num());
					rs=pstmt.executeQuery();
					
					if(rs.next()){
						if(rs.getString("qnaBoard_pass").equals(qnaboard.getQnaBoard_pass())) {
							check=true;							
						}
						 	check=false;
					}
		

		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return check;
}



public int check(qnaBoardbean article) {
//	System.out.println("check");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int check=-1;

	try {
		
		String sql="select * from qnaboard where qnaBoard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, article.getQnaBoard_num());
		rs=pstmt.executeQuery();

		
		if(rs.next()) {	
			if(rs.getString("qnaBoard_pass").equals(article.getQnaBoard_pass())) {
//				System.out.println("비밀번호일치");
				check=1;
			}else {
//				System.out.println("비밀번호틀림");
				check=0;
			}
					
		}


		} 
	 catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs); 
			close(pstmt);
		}
		return check;
}






public ArrayList<qnaBoardbean> selectarticlelistid(int page, int limit,String id) {
	
	ArrayList<qnaBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*4;
		
		
		String sql="select *from qnaBoard where qnaboard_id=? order by qnaboard_num desc limit ?,? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id); 
		pstmt.setInt(2, startrow);
		pstmt.setInt(3, limit); 
		rs=pstmt.executeQuery();
		
		
		list = new ArrayList<qnaBoardbean>();
		while(rs.next()) {
			qnaBoardbean article = new qnaBoardbean();
			article.setQnaBoard_num(rs.getInt("qnaboard_num"));
			article.setQnaBoard_id(rs.getString("qnaboard_id"));
			article.setQnaBoard_subject(rs.getString("qnaboard_subject"));
			article.setQnaBoard_content(rs.getString("qnaboard_content"));
			article.setQnaBoard_file(rs.getString("qnaboard_file"));
			article.setQnaBoard_re_ref(rs.getInt("qnaboard_re_ref"));
			article.setQnaBoard_re_lev(rs.getInt("qnaboard_re_lev"));
			article.setQnaBoard_re_seq(rs.getInt("qnaboard_re_seq"));
			article.setQnaBoard_readcount(rs.getInt("qnaboard_readcount"));
			article.setQnaBoard_date(rs.getDate("qnaboard_date"));
			article.setQnaBaord_tag(rs.getString("qnaboard_tag"));
			article.setQnaboard_reply(rs.getString("qnaboard_reply"));

			list.add(article);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		System.out.println("qboard selectarticlelist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	return list;
}

public int modifyArticle(qnaBoardbean article) {
//	System.out.println("수정dao");
	int insertCount = 0;
	
	PreparedStatement pstmt = null;

	
	try {

		String sql="update QnaBoard set QnaBoard_id=?, QnaBoard_subject=?, QnaBoard_content=?, QnaBoard_file=?, QnaBoard_tag=? where QnaBoard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, article.getQnaBoard_id());
		pstmt.setString(2, article.getQnaBoard_subject());
		pstmt.setString(3, article.getQnaBoard_content());
		pstmt.setString(4, article.getQnaBoard_file());
		pstmt.setString(5, article.getQnaBaord_tag());
		pstmt.setInt(6, article.getQnaBoard_num());
		insertCount=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("update에러");
	}finally {
		close(pstmt);
	}
	
	
	
	return insertCount;
	
	
	
	
}


public int delete(int boardnum) {
	int check=0;
	
	PreparedStatement pstmt = null;

	
	try {

		String sql="delete from qnaboard where qnaboard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, boardnum);
		check=pstmt.executeUpdate();

		
	} catch (SQLException e) {
		e.printStackTrace();
//		System.out.println("delete에러");
	}finally {
		close(pstmt);
	}
	
	
	
	return check;
}

public int selectlist3() {
	int listcount=0;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		String sql="select count(*) from qnaBoard where qnaBoard_reply is null";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			listcount=rs.getInt(1);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		System.out.println("qboard selectlist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	
	
	return listcount;
}

public ArrayList<qnaBoardbean> selectarticlelist3(int page, int limit) {
	ArrayList<qnaBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*10;
		
		
		String sql="select *from qnaBoard where qnaBoard_reply is null order by qnaBoard_re_ref desc, qnaBoard_re_seq asc limit ?, ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startrow);
		pstmt.setInt(2, limit); 
		rs=pstmt.executeQuery();
		
		
		list = new ArrayList<qnaBoardbean>();
		while(rs.next()) {
			qnaBoardbean article = new qnaBoardbean();
			article.setQnaBoard_num(rs.getInt("qnaboard_num"));
			article.setQnaBoard_id(rs.getString("qnaboard_id"));
			article.setQnaBoard_subject(rs.getString("qnaboard_subject"));
			article.setQnaBoard_content(rs.getString("qnaboard_content"));
			article.setQnaBoard_file(rs.getString("qnaboard_file"));
			article.setQnaBoard_re_ref(rs.getInt("qnaboard_re_ref"));
			article.setQnaBoard_re_lev(rs.getInt("qnaboard_re_lev"));
			article.setQnaBoard_re_seq(rs.getInt("qnaboard_re_seq"));
			article.setQnaBoard_readcount(rs.getInt("qnaboard_readcount"));
			article.setQnaBoard_date(rs.getDate("qnaboard_date"));
			article.setQnaBaord_tag(rs.getString("qnaboard_tag"));
			article.setQnaboard_reply(rs.getString("qnaboard_reply"));


			list.add(article);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		System.out.println("qboard selectarticlelist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	return list;
}



public ArrayList<qnaBoardbean> selectarticlelist4(int page, int limit) {
	ArrayList<qnaBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*10;
		
		
		String sql="select *from qnaBoard where qnaBoard_reply is not null order by qnaBoard_re_ref desc, qnaBoard_re_seq asc limit ?, ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startrow);
		pstmt.setInt(2, limit); 
		rs=pstmt.executeQuery();
		
		
		list = new ArrayList<qnaBoardbean>();
		while(rs.next()) {
			qnaBoardbean article = new qnaBoardbean();
			article.setQnaBoard_num(rs.getInt("qnaboard_num"));
			article.setQnaBoard_id(rs.getString("qnaboard_id"));
			article.setQnaBoard_subject(rs.getString("qnaboard_subject"));
			article.setQnaBoard_content(rs.getString("qnaboard_content"));
			article.setQnaBoard_file(rs.getString("qnaboard_file"));
			article.setQnaBoard_re_ref(rs.getInt("qnaboard_re_ref"));
			article.setQnaBoard_re_lev(rs.getInt("qnaboard_re_lev"));
			article.setQnaBoard_re_seq(rs.getInt("qnaboard_re_seq"));
			article.setQnaBoard_readcount(rs.getInt("qnaboard_readcount"));
			article.setQnaBoard_date(rs.getDate("qnaboard_date"));
			article.setQnaBaord_tag(rs.getString("qnaboard_tag"));
			article.setQnaboard_reply(rs.getString("qnaboard_reply"));


			list.add(article);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		System.out.println("qboard selectarticlelist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	return list;
}



public int selectlist4() {
	int listcount=0;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		String sql="select count(*) from qnaBoard where qnaBoard_reply is not null";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			listcount=rs.getInt(1);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		System.out.println("qboard selectlist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	
	
	return listcount;
}

}


	



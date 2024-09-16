package faq.dao;

import static faq.db.jdbcutil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import faq.vo.faqBoardbean;



public class faqBoardDAO {

private static faqBoardDAO instance; {
		
	}
	
	private faqBoardDAO() {}
	
	public static final faqBoardDAO getinstance() {
		if(instance==null) {
			instance=new faqBoardDAO();
		}
		
		return instance;
	}
	
	Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	public ArrayList<faqBoardbean> checkBot(){
		
		ArrayList<faqBoardbean> list = new ArrayList<faqBoardbean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql="select * from faqBoard";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				faqBoardbean fb = new faqBoardbean();
				fb.setFaqboard_subject(rs.getString(2));
				fb.setFaqboard_content(rs.getString(3));
				list.add(fb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		return list;
	}
	
	public int selectlist() {
		int listcount=0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql="select count(*) from faqBoard";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listcount=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			////system.out.println("qboard selectlist오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		
		
		return listcount;
	}

	

	public ArrayList<faqBoardbean> selectarticlelist(int page, int limit) {
		
		ArrayList<faqBoardbean> list=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			int startrow=(page-1)*8;
			
			
			String sql="select *from faqBoard order by faqBoard_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow); //시작레코드번호 
			pstmt.setInt(2, limit); //게시글 수
			rs=pstmt.executeQuery();
			
			
			list = new ArrayList<faqBoardbean>();
			while(rs.next()) {
				faqBoardbean article = new faqBoardbean();
				article.setFaqboard_num(rs.getInt("faqBoard_num"));
				article.setFaqboard_subject(rs.getString("faqBoard_subject"));
				article.setFaqboard_content(rs.getString("faqBoard_content"));
				article.setFaqBoard_tag(rs.getString("faqBoard_tag"));

				list.add(article);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			////system.out.println("countselect오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		return list;
	}

public ArrayList<faqBoardbean> searchselectlist(int page, int limit, String search) {
		
		ArrayList<faqBoardbean> list=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			int startrow=(page-1)*10;
			
			
			String sql="select * from faqboard where faqboard_subject like ? order by faqBoard_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs=pstmt.executeQuery();
			
			
			list = new ArrayList<faqBoardbean>();
			while(rs.next()) {
				faqBoardbean article = new faqBoardbean();
				article.setFaqboard_num(rs.getInt("faqBoard_num"));
				article.setFaqboard_subject(rs.getString("faqBoard_subject"));
				article.setFaqboard_content(rs.getString("faqBoard_content"));
				article.setFaqBoard_tag(rs.getString("faqBoard_tag"));

				list.add(article);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			////system.out.println("searchlist오류");
		}finally {
			close(rs); //jdbcutil.close()
			close(pstmt);
		}
		
		
		return list;
	}

public int searchselectlist(String search) {
	
	PreparedStatement pstmt=null;
	int count=0;
	ResultSet rs=null;
	
	
	
	try {
		String sql="select count(*) from faqboard where faqboard_subject like ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%"+search+"%");
		rs=pstmt.executeQuery();
	

		
		if(rs.next()) {	
				count=rs.getInt("count(*)");
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("faqboard selectarticlelist오류");
	}finally {
		close(rs); 
		close(pstmt);
	}
	
	
	
	
	return count;
}
	
	
public ArrayList<faqBoardbean> tagselectlist(int page, int limit, String search) {
	
	ArrayList<faqBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*10;
		
		
		String sql="select * from faqboard where faqboard_tag like ? order by faqBoard_num desc";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+search+"%");
		rs=pstmt.executeQuery();
		
		
		list = new ArrayList<faqBoardbean>();
		while(rs.next()) {
			faqBoardbean article = new faqBoardbean();
			article.setFaqboard_num(rs.getInt("faqBoard_num"));
			article.setFaqboard_subject(rs.getString("faqBoard_subject"));
			article.setFaqboard_content(rs.getString("faqBoard_content"));
			article.setFaqBoard_tag(rs.getString("faqBoard_tag"));

			list.add(article);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		////system.out.println("searchlist오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	return list;
}

public int tagselectlist(String search) {

PreparedStatement pstmt=null;
int count=0;
ResultSet rs=null;



try {
	String sql="select count(*) from faqboard where faqboard_tag like ?";
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, "%"+search+"%");
	rs=pstmt.executeQuery();


	
	if(rs.next()) {	
			count=rs.getInt("count(*)");
		
	}
	
} catch (SQLException e) {
	e.printStackTrace();
	////system.out.println("faqboard selectarticlelist오류");
}finally {
	close(rs); 
	close(pstmt);
}




return count;
}


public ArrayList<faqBoardbean> selectcontent(int num) {
	ArrayList<faqBoardbean> list=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	
	try {
		String sql="select * from faqboard where faqboard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();
		
		list = new ArrayList<faqBoardbean>();
		while(rs.next()) {
			faqBoardbean article = new faqBoardbean();
			article.setFaqboard_content(rs.getString("faqBoard_content"));
			list.add(article);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("faqboard selectarticlelist오류");
	}finally {
		close(pstmt);
	}
	
	
	
	return list;
}

public int insertArticle(faqBoardbean article) {
	int insertCount = 0;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
	
		
		String sql="insert into faqBoard(faqboard_subject,faqboard_content,faqBoard_tag) values(?,?,?);";
		pstmt = con.prepareStatement(sql);
	
		pstmt.setString(1, article.getFaqboard_subject());
		pstmt.setString(2, article.getFaqboard_content());
		pstmt.setString(3, article.getFaqBoard_tag());
		
		insertCount=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("insert에러");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	
	return insertCount;
}

public int delete(int num) {
	int check=0;
	
	PreparedStatement pstmt = null;

	
	try {

		String sql="delete from faqboard where faqboard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, num);
		check=pstmt.executeUpdate();

		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("delete에러");
	}finally {
		close(pstmt);
	}
	
	
	
	return check;
}

public int modifyArticle(faqBoardbean article) {
	////system.out.println("수정dao");
	int insertCount = 0;
	
	PreparedStatement pstmt = null;

	
	try {

		String sql="update faqBoard set Faqboard_subject=?, Faqboard_content=?, FaqBoard_tag=? where faqBoard_num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, article.getFaqboard_subject());
		pstmt.setString(2, article.getFaqboard_content());
		pstmt.setString(3, article.getFaqBoard_tag());
		pstmt.setInt(4, article.getFaqboard_num());
		insertCount=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("update에러");
	}finally {
		close(pstmt);
	}
	
	
	
	return insertCount;
	
}

public faqBoardbean getcontent(int faqboardnum) {
	faqBoardbean article=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {

		String sql="select * from faqboard where faqBoard_num=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, faqboardnum); 
		rs=pstmt.executeQuery();
		
		
		article = new faqBoardbean();
		if(rs.next()) {
			article = new faqBoardbean();
			article.setFaqboard_content(rs.getString("faqBoard_content"));
			article.setFaqboard_subject(rs.getString("faqBoard_subject"));
			article.setFaqBoard_tag(rs.getString("faqboard_tag"));
			article.setFaqboard_num(rs.getInt("faqBoard_num"));
	

		}
		
		
		
	
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		////system.out.println("board content오류");
	}finally {
		close(rs); 
		close(pstmt);
	}
	
	
	return article;
}

public ArrayList<faqBoardbean> selectarticlelist2(int page, int limit) {
	ArrayList<faqBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*5;
		
		
		String sql="select *from faqBoard order by faqBoard_num desc limit ?, ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startrow); //시작레코드번호 
		pstmt.setInt(2, limit); //게시글 수
		rs=pstmt.executeQuery();
		
		
		list = new ArrayList<faqBoardbean>();
		while(rs.next()) {
			faqBoardbean article = new faqBoardbean();
			article.setFaqboard_num(rs.getInt("faqBoard_num"));
			article.setFaqboard_subject(rs.getString("faqBoard_subject"));
			article.setFaqboard_content(rs.getString("faqBoard_content"));
			article.setFaqBoard_tag(rs.getString("faqBoard_tag"));

			list.add(article);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		////system.out.println("countselect오류");
	}finally {
		close(rs); //jdbcutil.close()
		close(pstmt);
	}
	
	
	return list;
}



	
}

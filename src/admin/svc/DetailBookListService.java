package admin.svc;

import org.json.simple.JSONArray;

import admin.dao.AdminDAO;

import static member.db.JdbcUtill.*;

import java.sql.Connection;

public class DetailBookListService {


	public JSONArray DetailBookList(int book_num) {
		JSONArray DetailBookList=null;
		Connection con =getConnection();
		
		AdminDAO adao=AdminDAO.adao;
		
		adao.setConnection(con);
		
		DetailBookList=adao.DetailBookList(book_num);
		
		close(con);
		
		
		return DetailBookList;
	}

}

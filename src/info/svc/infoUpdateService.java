package info.svc;

import static info.db.jdbcutil.*;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.mypageDAO;
import info.vo.ListBean;

public class infoUpdateService {

	public boolean updateInfo(ListBean lb) {
		
		mypageDAO dao = mypageDAO.getinstance();
		Connection con = getconnection();
		dao.setCon(con);
		
		int check = dao.infoUpdate(lb);
		
		try 
		{
			if(check > 0)
			{
				con.commit();
				con.close();
				return true;
			}
			else
			{
				con.rollback();
				con.close();
				return false;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}

	}

}

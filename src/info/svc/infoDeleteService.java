package info.svc;

import static info.db.jdbcutil.*;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.mypageDAO;

public class infoDeleteService {

	public int checkPass(String id, String pass) {
		
		int a = -1;
		mypageDAO dao = mypageDAO.getinstance();
		Connection con = getconnection();
		dao.setCon(con);
		boolean check = dao.checkDelete(id,pass);
		if(check)
		{
			a = dao.deletePro(id);
			try 
			{
				if(a > 0)
				{
					con.commit();
				}
				else 
				{
					con.rollback();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}

		return a;
	}

}

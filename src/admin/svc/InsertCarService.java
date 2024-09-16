package admin.svc;

import book.dao.CarDAO;
import book.vo.CarBean;
import static member.db.JdbcUtill.*;

import java.sql.Connection;

import admin.dao.AdminDAO;
public class InsertCarService {

	public boolean Insertcar(CarBean cb) {
		
		boolean isinsertcar=false;
		
		Connection con=getConnection();
		
		CarDAO cdao=CarDAO.getInstance();
		
		cdao.setConnection(con);
		
		isinsertcar=cdao.insertCar(cb);
		
		if(isinsertcar) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isinsertcar;
	}

}

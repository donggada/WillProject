package book.svc;

import static book.db.JdbcUtil.close;
import static book.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

import book.dao.CarDAO;
import book.vo.CarBean;
import review.dao.ReviewDAO;
import review.vo.ReviewBean;

public class CarListService {

	public ArrayList<CarBean> getCarList() {

		
		Connection con = getConnection();

		CarDAO carDAO = CarDAO.getInstance();

		carDAO.setConnection(con);
		
		ArrayList<CarBean> carList = carDAO.getCarListBean();

		close(con);
		
		return carList;
	}
	
	public LinkedList<CarBean> getCarLinkedList(boolean smoke, boolean pet, boolean baby) {

		
		Connection con = getConnection();

		CarDAO carDAO = CarDAO.getInstance();

		carDAO.setConnection(con);
		
		LinkedList<CarBean> carList = carDAO.getCarLinkedListBeanOption(smoke,pet,baby);

		close(con);
		
		return carList;
	}
	
	//전체 자량 수 조회 getList()
		public int getListCount() {
			
			int listCount = 0;
			
			Connection con = getConnection();
			CarDAO carDAO = CarDAO.getInstance();
			carDAO.setConnection(con);
			
			listCount = carDAO.selectCarCount();
			close(con);
			
			return listCount;
		}

		public ArrayList<CarBean> getCarList(int page, int limit) {
			ArrayList<CarBean> carList = null;
			Connection con = getConnection();
			CarDAO carDAO = CarDAO.getInstance();
			
			carDAO.setConnection(con);
			
			carList = carDAO.selectCarList(page,limit);
			
			close(con);
			
			return carList;
		}
	
	
	
}

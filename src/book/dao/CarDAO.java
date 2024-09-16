package book.dao;

import static review.db.jdbcUtil.close;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

//import book.db.DBConnection;
import book.vo.CarBean;

public class CarDAO {

	private static CarDAO instance = new CarDAO();

	private CarDAO() {
	}

	public static CarDAO getInstance() {

		if (instance == null) {
			instance = new CarDAO();
		}

		return instance;
	}

	Connection con;

	public void setConnection(Connection con) {
		this.con = con;

	}

	public int userCheck(String id, String pass) {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from member where id = ?;";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pass)) {
					Count = 1;
				} else {
					Count = 0;
				}

			} else {
				Count = -1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return Count;
	}

	public int userCheck2(String id, String pass) throws LoginFailException {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from member where id = ?;";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pass)) {
					Count = 1;
				} else {
					Count = 0;
					throw new LoginFailException("로그인 오류 : 일치하지 않는 패스워드");
				}

			} else {
				Count = -1;
				throw new LoginFailException("로그인 오류 : 아이디 없슴");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return Count;
	}

	public boolean insertCar(CarBean cb) {
		boolean b = false;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try {
//			con = DBConnection.getInstance().GetConnetion();
			String st1="select MAX(car_id) FROM car";
			pstmt=con.prepareStatement(st1);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cb.setCar_id(rs.getInt(1)+1);
			}
			StringBuffer sql = new StringBuffer("insert into car");
			sql.append("(car_is_rent, car_maker, car_name, car_type,");
			sql.append(" car_people_max, car_people_possible, car_year, car_oil,");
			sql.append(" car_is_auto, car_license_type, car_license_year, car_need_year,");
			sql.append(" car_cc, car_price_normal, car_price_sale, car_function, car_trunk,");
			sql.append(" car_color, car_is_navi, car_is_pet, car_is_open, car_is_smoke,car_num,car_id)");
			sql.append(" values(?, ?, ?, ?,");
			sql.append("?, ?, ?, ?,");
			sql.append("?, ?, ?, ?,");
			sql.append("?, ?, ?, ?, ?,");
			sql.append("?, ?, ?, ?, ?,?,?)");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setBoolean(1, true);
			pstmt.setString(2, cb.getCar_maker());
			pstmt.setString(3, cb.getCar_name());
			pstmt.setInt(4, cb.getCar_type().getInt());
			pstmt.setInt(5, cb.getCar_people_max());
			pstmt.setInt(6, cb.getCar_people_max());
			pstmt.setInt(7, cb.getCar_year());
			pstmt.setInt(8, cb.getCar_oil().getInt());
			pstmt.setBoolean(9, cb.isCar_is_auto());
			pstmt.setInt(10, cb.getCar_license_type().getInt());
			pstmt.setInt(11, 1);
			pstmt.setInt(12, 1);
			pstmt.setInt(13, cb.getCar_cc());
			pstmt.setInt(14, cb.getCar_price_normal());
			pstmt.setInt(15, cb.getCar_price_sale());
			pstmt.setInt(16, cb.getCar_function().getInt());
			pstmt.setInt(17, 1);
			pstmt.setString(18, cb.getCar_color());
			pstmt.setBoolean(19, cb.isCar_is_navi());
			pstmt.setBoolean(20, cb.isCar_is_pet());
			pstmt.setBoolean(21, cb.isCar_is_open());
			pstmt.setBoolean(22, cb.isCar_is_smoke());
			pstmt.setString(23, cb.getCar_num());
			pstmt.setInt(24,cb.getCar_id());

			if (pstmt.executeUpdate() == 0) {
				b = false;
			} else {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insercar오류"+e);
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
//				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return b;
	}

	public boolean updateCar(CarBean cb) {
		boolean b = false;
//		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			con = DBConnection.getInstance().GetConnetion();

			StringBuffer sql = new StringBuffer("UPDATE car");
			sql.append(" SET car_is_rent = ?, car_maker = ?, car_name = ?, car_type = ?,");
			sql.append(" car_people_max = ?, car_people_possible = ?, car_year = ?, car_oil = ?,");
			sql.append(" car_is_auto = ?, car_license_type = ?, car_license_year = ?, car_need_year = ?,");
			sql.append(" car_cc = ?, car_price_normal = ?, car_price_sale = ?, car_function = ?, car_trunk = ?,");
			sql.append(" car_color = ?, car_is_navi = ?, car_is_pet = ?, car_is_open = ?, car_is_smoke = ?");
			sql.append(" WHERE car_id = ?");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setBoolean(1, cb.isCar_is_rent());
			pstmt.setString(2, cb.getCar_maker());
			pstmt.setString(3, cb.getCar_name());
			pstmt.setInt(4, cb.getCar_type().getInt());
			pstmt.setInt(5, cb.getCar_people_max());
			pstmt.setInt(6, cb.getCar_people_possible());
			pstmt.setInt(7, cb.getCar_year());
			pstmt.setInt(8, cb.getCar_oil().getInt());
			pstmt.setBoolean(9, cb.isCar_is_auto());
			pstmt.setInt(10, cb.getCar_license_type().getInt());
			pstmt.setInt(11, cb.getCar_license_year());
			pstmt.setInt(12, cb.getCar_need_year());
			pstmt.setInt(13, cb.getCar_cc());
			pstmt.setInt(14, cb.getCar_price_normal());
			pstmt.setInt(15, cb.getCar_price_sale());
			pstmt.setInt(16, cb.getCar_function().getInt());
			pstmt.setInt(17, cb.getCar_trunk());
			pstmt.setString(18, cb.getCar_color());
			pstmt.setBoolean(19, cb.isCar_is_navi());
			pstmt.setBoolean(20, cb.isCar_is_pet());
			pstmt.setBoolean(21, cb.isCar_is_open());
			pstmt.setBoolean(22, cb.isCar_is_smoke());
			pstmt.setInt(23, cb.getCar_id());

			if (pstmt.executeUpdate() == 0) {
				b = false;
			} else {
				b = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return b;
	}

	public ArrayList<Vector> getCarList() throws LoginFailException {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Vector> memberList = new ArrayList<Vector>();
		CarBean mb = new CarBean();

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from car";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mb.setCar_cc(rs.getInt("car_cc"));
				mb.setCar_color(rs.getString("car_color"));
				mb.setCar_function(rs.getInt("car_function"));
				mb.setCar_id(rs.getInt("car_id")); //
				mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
				mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
				mb.setCar_is_open(rs.getBoolean("car_is_open"));
				mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
				mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
				mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
				mb.setCar_license_type(rs.getInt("car_license_type"));
				mb.setCar_license_year(rs.getInt("car_license_year"));
				mb.setCar_maker(rs.getString("car_maker")); //
				mb.setCar_name(rs.getString("car_name")); //
				mb.setCar_need_year(rs.getInt("car_need_year"));
				mb.setCar_oil(rs.getInt("car_oil"));
				mb.setCar_people_max(rs.getInt("car_people_max")); //
				mb.setCar_people_possible(rs.getInt("car_people_possible")); //
				mb.setCar_price_normal(rs.getInt("car_price_normal"));
				mb.setCar_price_sale(rs.getInt("car_price_sale"));
				mb.setCar_trunk(rs.getInt("car_trunk"));
				mb.setCar_type(rs.getInt("car_type")); //
				mb.setCar_year(rs.getInt("car_year"));

				Vector v = new Vector();
				v.add(mb.getCar_id());
				v.add(mb.getCar_name());
				v.add(mb.isCar_is_rent());
				v.add(mb.getCar_maker());
				v.add(mb.getCar_type());

				v.add(mb.getCar_people_max());
				v.add(mb.getCar_people_possible());
				v.add(mb.getCar_year());
				v.add(mb.getCar_oil());
				v.add(mb.isCar_is_auto());

				v.add(mb.getCar_license_type());
				v.add(mb.getCar_license_year());
				v.add(mb.getCar_need_year());
				v.add(mb.getCar_cc());
				v.add(mb.getCar_price_normal());

				v.add(mb.getCar_price_sale());
				v.add(mb.getCar_function());
				v.add(mb.getCar_trunk());
				v.add(mb.getCar_color());
				v.add(mb.isCar_is_navi());

				v.add(mb.isCar_is_pet());
				v.add(mb.isCar_is_open());
				v.add(mb.isCar_is_smoke());

				memberList.add(v);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return memberList;
	}

	// 벡터 -> 카빈
	public ArrayList<CarBean> getCarListBean() {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CarBean> memberList = new ArrayList<CarBean>();

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from car";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				CarBean mb = new CarBean();

				mb.setCar_cc(rs.getInt("car_cc"));
				mb.setCar_color(rs.getString("car_color"));
				mb.setCar_function(rs.getInt("car_function"));
				mb.setCar_id(rs.getInt("car_id")); //
				mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
				mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
				mb.setCar_is_open(rs.getBoolean("car_is_open"));
				mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
				mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
				mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
				mb.setCar_license_type(rs.getInt("car_license_type"));
				mb.setCar_license_year(rs.getInt("car_license_year"));
				mb.setCar_maker(rs.getString("car_maker")); //
				mb.setCar_name(rs.getString("car_name")); //
				mb.setCar_need_year(rs.getInt("car_need_year"));
				mb.setCar_oil(rs.getInt("car_oil"));
				mb.setCar_people_max(rs.getInt("car_people_max")); //
				mb.setCar_people_possible(rs.getInt("car_people_possible")); //
				mb.setCar_price_normal(rs.getInt("car_price_normal"));
				mb.setCar_price_sale(rs.getInt("car_price_sale"));
				mb.setCar_trunk(rs.getInt("car_trunk"));
				mb.setCar_type(rs.getInt("car_type")); //
				mb.setCar_year(rs.getInt("car_year"));

				memberList.add(mb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return memberList;
	}
	
	
	public LinkedList<CarBean> getCarLinkedListBean() {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<CarBean> memberList = new LinkedList<CarBean>();

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from car";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				CarBean mb = new CarBean();

				mb.setCar_cc(rs.getInt("car_cc"));
				mb.setCar_color(rs.getString("car_color"));
				mb.setCar_function(rs.getInt("car_function"));
				mb.setCar_id(rs.getInt("car_id")); //
				mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
				mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
				mb.setCar_is_open(rs.getBoolean("car_is_open"));
				mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
				mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
				mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
				mb.setCar_license_type(rs.getInt("car_license_type"));
				mb.setCar_license_year(rs.getInt("car_license_year"));
				mb.setCar_maker(rs.getString("car_maker")); //
				mb.setCar_name(rs.getString("car_name")); //
				mb.setCar_need_year(rs.getInt("car_need_year"));
				mb.setCar_oil(rs.getInt("car_oil"));
				mb.setCar_people_max(rs.getInt("car_people_max")); //
				mb.setCar_people_possible(rs.getInt("car_people_possible")); //
				mb.setCar_price_normal(rs.getInt("car_price_normal"));
				mb.setCar_price_sale(rs.getInt("car_price_sale"));
				mb.setCar_trunk(rs.getInt("car_trunk"));
				mb.setCar_type(rs.getInt("car_type")); //
				mb.setCar_year(rs.getInt("car_year"));

				memberList.add(mb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return memberList;
	}
	

	public CarBean getCar(int carid) throws LoginFailException {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CarBean mb = new CarBean();

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from car where car_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, carid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb.setCar_cc(rs.getInt("car_cc"));
				mb.setCar_color(rs.getString("car_color"));
				mb.setCar_function(rs.getInt("car_function"));
				mb.setCar_id(rs.getInt("car_id")); //
				mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
				mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
				mb.setCar_is_open(rs.getBoolean("car_is_open"));
				mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
				mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
				mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
				mb.setCar_license_type(rs.getInt("car_license_type"));
				mb.setCar_license_year(rs.getInt("car_license_year"));
				mb.setCar_maker(rs.getString("car_maker")); //
				mb.setCar_name(rs.getString("car_name")); //
				mb.setCar_need_year(rs.getInt("car_need_year"));
				mb.setCar_oil(rs.getInt("car_oil"));
				mb.setCar_people_max(rs.getInt("car_people_max")); //
				mb.setCar_people_possible(rs.getInt("car_people_possible")); //
				mb.setCar_price_normal(rs.getInt("car_price_normal"));
				mb.setCar_price_sale(rs.getInt("car_price_sale"));
				mb.setCar_trunk(rs.getInt("car_trunk"));
				mb.setCar_type(rs.getInt("car_type")); //
				mb.setCar_year(rs.getInt("car_year"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return mb;
	}

	public boolean deleteCar(int idx) {
		int Count = 0;
//		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			con = DBConnection.getInstance().GetConnetion();

			String sql = "delete from car where car_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);

			Count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		boolean b = false;

		if (Count != 0) {
			b = true;
		}

		return b;
	}

	public boolean randomInsert(int carid, int carnum) {
		CarBean cb = null;
		try {
			cb = getCar(carid);
		} catch (LoginFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		for (int x = 0; x < carnum; x++) {
			cb.setCar_year((int) (Math.random() * 30));

			int color = (int) (Math.random() * 10);
			String str_color = "흰색";
			switch (color) {
			case 0:
				str_color = "흰색";
				break;
			case 1:
				str_color = "검은색";
				break;
			case 2:
				str_color = "파랑색";
				break;
			case 3:
				str_color = "빨강색";
				break;
			case 4:
				str_color = "회색";
				break;
			case 5:
				str_color = "노랑색";
				break;
			case 6:
				str_color = "녹색";
				break;
			case 7:
				str_color = "분홍색";
				break;
			case 8:
				str_color = "보라색";
				break;
			case 9:
				str_color = "하늘색";
				break;
			}
			cb.setCar_color(str_color);

			cb.setCar_is_auto((int) (Math.random() * 2) == 0 ? false : true);
			cb.setCar_is_navi((int) (Math.random() * 2) == 0 ? false : true);
			cb.setCar_is_open((int) (Math.random() * 2) == 0 ? false : true);
			cb.setCar_is_pet((int) (Math.random() * 2) == 0 ? false : true);
			cb.setCar_is_rent((int) (Math.random() * 2) == 0 ? false : true);
			cb.setCar_is_smoke((int) (Math.random() * 2) == 0 ? false : true);

			insertCar(cb);
		}
		return true;

	}

		//전체 차량 수 조회
		public int selectCarCount() {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				String sql = "SELECT COUNT(car_id) FROM car";
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
		//전체 차량 조회하기
		public ArrayList<CarBean> selectCarList(int page, int limit) {
			ArrayList<CarBean> carList = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				int startRow = (page-1) *10;
				String sql = "SELECT * FROM car LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, limit);
				rs = pstmt.executeQuery();
				
				carList = new ArrayList<CarBean>();
				while(rs.next()) {
					CarBean mb = new CarBean();
					
					mb.setCar_cc(rs.getInt("car_cc"));
					mb.setCar_color(rs.getString("car_color"));
					mb.setCar_function(rs.getInt("car_function"));
					mb.setCar_id(rs.getInt("car_id")); //
					mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
					mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
					mb.setCar_is_open(rs.getBoolean("car_is_open"));
					mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
					mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
					mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
					mb.setCar_license_type(rs.getInt("car_license_type"));
					mb.setCar_license_year(rs.getInt("car_license_year"));
					mb.setCar_maker(rs.getString("car_maker")); //
					mb.setCar_name(rs.getString("car_name")); //
					mb.setCar_need_year(rs.getInt("car_need_year"));
					mb.setCar_oil(rs.getInt("car_oil"));
					mb.setCar_people_max(rs.getInt("car_people_max")); //
					mb.setCar_people_possible(rs.getInt("car_people_possible")); //
					mb.setCar_price_normal(rs.getInt("car_price_normal"));
					mb.setCar_price_sale(rs.getInt("car_price_sale"));
					mb.setCar_trunk(rs.getInt("car_trunk"));
					mb.setCar_type(rs.getInt("car_type")); //
					mb.setCar_year(rs.getInt("car_year"));

					carList.add(mb);
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return carList;
		}
		

		
		public LinkedList<CarBean> getCarLinkedListBeanOption(boolean smoke, boolean pet, boolean baby) {
			int Count = 0;
//			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			LinkedList<CarBean> memberList = new LinkedList<CarBean>();
			System.out.println("getCarLinkedListBeanOption 구간");
			System.out.println(smoke);
			System.out.println(pet);
			System.out.println(baby);
			
			
			try {
//				con = DBConnection.getInstance().GetConnetion();
				
				StringBuffer sqlResult = new StringBuffer();
				
				sqlResult.append("select * from car where");
				
				if(smoke) {
					sqlResult.append(" car_is_smoke=? and");
				}
				
				if(pet) {
					sqlResult.append(" car_is_pet=? and");
				}
				
				if(baby) {
					sqlResult.append(" car_is_open=?");
				}else {
					
					sqlResult = new StringBuffer(sqlResult.substring(0,sqlResult.length()-3));
				}
				
				System.out.println(sqlResult.toString());
				
				pstmt = con.prepareStatement(sqlResult.toString());
				
				int i=1	;
				if(smoke) {
					pstmt.setBoolean(i, smoke);
					i++;
				}
				if(pet) {
					pstmt.setBoolean(i, pet);
					i++;
				}
				if(baby) {
					pstmt.setBoolean(i, baby);
					
				}
			
				rs = pstmt.executeQuery();

				while (rs.next()) {

					CarBean mb = new CarBean();

					mb.setCar_cc(rs.getInt("car_cc"));
					mb.setCar_color(rs.getString("car_color"));
					mb.setCar_function(rs.getInt("car_function"));
					mb.setCar_id(rs.getInt("car_id")); //
					mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
					mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
					mb.setCar_is_open(rs.getBoolean("car_is_open"));
					mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
					mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
					mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
					mb.setCar_license_type(rs.getInt("car_license_type"));
					mb.setCar_license_year(rs.getInt("car_license_year"));
					mb.setCar_maker(rs.getString("car_maker")); //
					mb.setCar_name(rs.getString("car_name")); //
					mb.setCar_need_year(rs.getInt("car_need_year"));
					mb.setCar_oil(rs.getInt("car_oil"));
					mb.setCar_people_max(rs.getInt("car_people_max")); //
					mb.setCar_people_possible(rs.getInt("car_people_possible")); //
					mb.setCar_price_normal(rs.getInt("car_price_normal"));
					mb.setCar_price_sale(rs.getInt("car_price_sale"));
					mb.setCar_trunk(rs.getInt("car_trunk"));
					mb.setCar_type(rs.getInt("car_type")); //
					mb.setCar_year(rs.getInt("car_year"));

					memberList.add(mb);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return memberList;
		}
		
		
}




class LoginFailException extends Exception {

	public LoginFailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}

package admin.dao;

import static member.db.JdbcUtill.*;
import static qna.db.jdbcutil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.vo.CarBean;
import book.vo.BookBean;
import book.vo.CarBean.CAR_TYPE;
import faq.vo.faqBoardbean;
import member.dao.MemberDAO;
import member.vo.MemberBean;
import qna.vo.qnaBoardbean;
import review.vo.ReviewBean;

public class AdminDAO {

	public static AdminDAO getMdao() {
		return adao;
	}

private AdminDAO() {
	
}

public static AdminDAO adao=new AdminDAO();

Connection con;
public void setConnection(Connection con) {
	this.con = con;
}

public int selectListCount(String target, String table) {
	int listCount = 0;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "SELECT COUNT(?) FROM "+table;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, target);
		rs = pstmt.executeQuery();
	
		
	
		if(rs.next()) {
			listCount = rs.getInt(1);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectListCount() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt); 
	}
	
	return listCount;
	
}

public int selectListCount(String target, String table,String carsearch1,String carsearch2) {
	int listCount = 0;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "SELECT COUNT(?) FROM "+table+" where "+carsearch1+" like ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, target);
		pstmt.setString(2, "%"+carsearch2+"%");
		rs = pstmt.executeQuery();
	
		
	
		if(rs.next()) {
			listCount = rs.getInt(1);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectListCount() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt); 
	}
	
	return listCount;
	
}

public ArrayList<MemberBean> selectMemberList(int page, int limit) {
	ArrayList<MemberBean> MemberList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM member order by member_num desc LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(2, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		MemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb = new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			
			MemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectMemberList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return MemberList;
	
}


public ArrayList<MemberBean> selectMemberListM(String taget) {
	ArrayList<MemberBean> MemberList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {

		String sql = "SELECT * FROM member where member_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, taget);
		rs = pstmt.executeQuery();
		
		MemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb = new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			
			MemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectMemberList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return MemberList;
	
}

public ArrayList<CarBean> selectCarList(int page, int limit) {
ArrayList<CarBean> CarList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM car LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(2, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		CarList = new ArrayList<CarBean>();
		
		while(rs.next()) {
			CarBean cb =new CarBean();
			cb.setCar_num(rs.getString("car_num"));
			cb.setCar_id(rs.getInt("car_id"));
			cb.setCar_maker(rs.getString("car_maker"));
			cb.setCar_name(rs.getString("car_name"));
			cb.setCar_type(CAR_TYPE.values()[rs.getInt("car_type")].toString());
			cb.setCar_price_normal(rs.getInt("car_price_normal"));
			
	
			
			CarList.add(cb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return CarList;
}	

public ArrayList<CarBean> selectCarList(String carsearch1, String carsearch2, int page, int limit) {
	ArrayList<CarBean> SelectCarList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM car where "+carsearch1+" like ? LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+carsearch2+"%");
		pstmt.setInt(2, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(3, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		SelectCarList = new ArrayList<CarBean>();
		
		while(rs.next()) {
			CarBean cb =new CarBean();
			cb.setCar_id(rs.getInt("car_id"));
			cb.setCar_maker(rs.getString("car_maker"));
			cb.setCar_name(rs.getString("car_name"));
			cb.setCar_type(CAR_TYPE.values()[rs.getInt("car_type")].toString());
			cb.setCar_num(rs.getString("car_num"));
			cb.setCar_price_normal(rs.getInt("car_price_normal"));
			SelectCarList.add(cb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		close(rs); 
		close(pstmt);
	}
	
	
	
	
	return SelectCarList;
}

public ArrayList<MemberBean> selectMemberList(String carsearch1, String carsearch2, int page, int limit) {
	ArrayList<MemberBean> SelectMemberList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM member where "+carsearch1+" like ? LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+carsearch2+"%");
		pstmt.setInt(2, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(3, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		SelectMemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb =new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			SelectMemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		close(rs); 
		close(pstmt);
	}
	
	
	
	
	return SelectMemberList;
}

public ArrayList<CarBean> selectgraph(String target1) {
ArrayList<CarBean> CarList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		String sql = "select "+target1+" as taget,count(car_id) as count from car group by "+target1;
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		CarList = new ArrayList<CarBean>();
		
		while(rs.next()) {
			CarBean cb =new CarBean();
			cb.setCar_id(rs.getInt("count"));
			switch (rs.getString("taget")) {
			case "0": cb.setCar_maker("경차");
				break;
			case "1": cb.setCar_maker("소형");
				break;
			case "2": cb.setCar_maker("중형");
				break;
			case "3": cb.setCar_maker("준대형");
				break;
			case "4": cb.setCar_maker("대형");
				break;
			case "5": cb.setCar_maker("승합");
				break;
			case "6": cb.setCar_maker("SUV/RV");
				break;
			case "7": cb.setCar_maker("전기차");
				break;
			case "8": cb.setCar_maker("수입차");
				break;
			default:cb.setCar_maker(rs.getString("taget"));	
				break;
			}	
	
			
			CarList.add(cb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return CarList;
}

public ArrayList<CarBean> selectgraph(String target1,String target2) {
ArrayList<CarBean> CarList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		String sql = "select "+target1+" as taget,count(car_id) as count from car where "+target2+" group by "+target1;
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		CarList = new ArrayList<CarBean>();
		
		while(rs.next()) {
			CarBean cb =new CarBean();
			cb.setCar_id(rs.getInt("count"));
			cb.setCar_maker(rs.getString("taget"));		
	
			
			CarList.add(cb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return CarList;
}



public ArrayList<qnaBoardbean> selectAdminBoardList(int page, int limit) {
	ArrayList<qnaBoardbean> list=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		int startrow=(page-1)*10;
		
		
		String sql="select *from qnaBoard order by qnaBoard_date desc,qnaBoard_reply desc ,qnaBoard_num asc limit ?, ?";
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
				e.printStackTrace();
		System.out.println("selectAdminBoardList 오류"+e);
	}finally {
		close(rs); 
		close(pstmt);
	}
	
	
	return list;
	
}

public boolean mmdelete(int taget,String table) {
	boolean isdelete=false;
	
PreparedStatement pstmt = null;

	
	try {

		String sql="delete from "+table+" where "+table+"_num =?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, taget);
		pstmt.executeUpdate();
		isdelete=true;

		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("delete에러");
	}finally {
		close(pstmt);
	}
	
	
	
	
	
	
	return isdelete;
}	




public boolean modifyArticle(MemberBean article) {
	boolean ismodify= false;
	
	PreparedStatement pstmt = null;

	
	try {

		String sql=
				"update member set Member_pass=?, Member_name=?, Member_age=?, Member_gender=?, Member_tel=?, Member_adress=?, Member_email=?, Member_license=?, Member_smoke=?, Member_pet=?, member_baby=?, Member_grade=? where member_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, article.getMember_pass());
		pstmt.setString(2, article.getMember_name());
		pstmt.setString(3, article.getMember_age());
		pstmt.setString(4, article.getMember_gender());
		pstmt.setString(5, article.getMember_tel());
		pstmt.setString(6, article.getMember_adress());
		pstmt.setString(7, article.getMember_email());
		pstmt.setString(8, article.getMember_license());
		pstmt.setString(9, article.getMember_smoke());
		pstmt.setString(10, article.getMember_pet());
		pstmt.setString(11, article.getMember_boby());
		pstmt.setString(12, article.getMember_grade());
		pstmt.setString(13, article.getMember_id());
		pstmt.executeUpdate();
		ismodify=true;
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("update에러");
	}finally {
		close(pstmt);
	}
	
	
	
	return ismodify;
	
}

public JSONArray CallPage() {
	JSONArray PoPpage=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql="select *from poppage";
		pstmt = con.prepareStatement(sql); 
		rs=pstmt.executeQuery();
		PoPpage=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			jo.put("image", rs.getString(1));
		
			PoPpage.add(jo);
		}
	} catch (SQLException e) {
	System.out.println("CallPage오류"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	
	
		return PoPpage;
}

public int PoPUpload(ReviewBean reviewBean) {
	int isuploadcount=0;
	PreparedStatement pstmt = null;
	
	try {
		String sql="UPDATE poppage SET file_name=? where idx=1";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, reviewBean.getReview_file());
		isuploadcount=pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println("PoPUpload"+e);
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return isuploadcount;
}

public ArrayList<CarBean> SalesChart() {
	ArrayList<CarBean> SalesList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql="SELECT sum(a.book_price) as count,\n" + 
				"b.car_maker,b.car_name\n" + 
				"FROM book a JOIN car b\n" + 
				"ON (a.car_id = b.car_id)\n" + 
				"group by b.car_name\n" + 
				"order by sum(a.book_price) desc\n" + 
				"limit 0,5";
		
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		SalesList=new ArrayList<CarBean>();
		while(rs.next()) {
			CarBean cb=new CarBean();
			cb.setCar_id(rs.getInt(1));
			cb.setCar_maker(rs.getString(2));
			cb.setCar_name(rs.getString(3));
			SalesList.add(cb);
			
		}
	} catch (SQLException e) {
		System.out.println("SalesChart"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
		
	}
		return SalesList;
}

public JSONArray DetailCarList(int car_id) {
	JSONArray DetailCarList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql="select *from car where car_id=?";
		pstmt = con.prepareStatement(sql); 
		pstmt.setInt(1, car_id);
		rs=pstmt.executeQuery();
		DetailCarList=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			jo.put("id", rs.getInt("car_id"));
			jo.put("num", rs.getInt("car_num"));
			jo.put("maker", rs.getString("car_maker"));
			jo.put("type", CAR_TYPE.values()[rs.getInt("car_type")].toString());
			jo.put("year", rs.getString("car_year"));
			jo.put("oil", rs.getString("car_oil"));
			jo.put("auto", rs.getString("car_is_auto"));
			jo.put("cc", rs.getString("car_cc"));
			jo.put("trunk", rs.getString("car_trunk"));
			jo.put("pet", rs.getString("car_is_pet"));
			jo.put("navi", rs.getString("car_is_navi"));
			jo.put("smoke", rs.getString("car_is_smoke"));
			jo.put("color", rs.getString("car_is_smoke"));
			jo.put("open", rs.getString("car_is_smoke"));
			jo.put("name", rs.getString("car_name"));
			
			
			
			DetailCarList.add(jo);
		}
	} catch (SQLException e) {
	System.out.println("DetailCarList오류"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	
	
		return DetailCarList;
}

public ArrayList<BookBean> statslist() {
	ArrayList statslist=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql= " SELECT DATE(`book_date`) AS `date`, \n" + 
					"       sum(`book_price`) AS `count`\n" + 
					"  FROM book\n" + 
					"  where year(now())\n" + 
					"  GROUP BY `date`";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		statslist=new ArrayList<BookBean>();
		while(rs.next()) {
			BookBean bb=new BookBean();
			bb.setBook_date(rs.getDate("date"));
			bb.setBook_price(rs.getInt("count"));
			statslist.add(bb);
			
		}
	} catch (SQLException e) {
		System.out.println("SalesChart"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
		
	}
	
	
	return statslist;
}

public ArrayList<BookBean> Monthlist() {
	ArrayList<BookBean> Monthlist=null;
	ArrayList statslist=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql= "SELECT sum(book_price) as count FROM book WHERE\n" + 
				"( book_date > LAST_DAY(NOW() - interval 1 month) AND book_date <= LAST_DAY(NOW()) );";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		Monthlist=new ArrayList<BookBean>();
		while(rs.next()) {
			BookBean bb=new BookBean();
			bb.setBook_price(rs.getInt("count"));
			Monthlist.add(bb);
			
		}
	} catch (SQLException e) {
		System.out.println("Monthlist"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
		
	}
	
	
	return Monthlist;
}

public ArrayList<MemberBean> selectMemberList(int page, int limit, String parameter) {
ArrayList<MemberBean> MemberList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM member where member_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, parameter);
		rs = pstmt.executeQuery();
		
		MemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb = new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			
			MemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectMemberList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return MemberList;
}

public ArrayList<MemberBean> selectMemberSearchList(int page, int limit, String select, String search) {
	ArrayList<MemberBean> SelectMemberList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM member where "+select+" like ? LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+search+"%");
		pstmt.setInt(2, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(3, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		SelectMemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb =new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			SelectMemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		close(rs); 
		close(pstmt);
	}
	
	
	
	
	return SelectMemberList;
}

public JSONArray DetailBookList(int book_num) {
	JSONArray DetailBookList=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql="select *from book where book_num=?";
		pstmt = con.prepareStatement(sql); 
		pstmt.setInt(1, book_num);
		rs=pstmt.executeQuery();
		DetailBookList=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			jo.put("book_num", rs.getInt("book_num"));
			jo.put("book_id", rs.getString("member_id"));
			jo.put("book_date", rs.getString("book_date"));
			jo.put("book_price", rs.getInt("book_price"));
			jo.put("insurance", rs.getInt("insurance"));
			jo.put("car_id", rs.getInt("car_id"));
			jo.put("book_state", rs.getInt("book_state"));
			jo.put("pickup_date", rs.getString("pickup_date"));
			jo.put("end_date", rs.getString("end_date"));
			jo.put("book_state", rs.getString("book_state"));
			
			
			DetailBookList.add(jo);
		}
	} catch (SQLException e) {
	System.out.println("DetailCarList오류"+e);
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	
	
		return DetailBookList;
}

public ArrayList<MemberBean> selectMemberSearchListlineup(int page, int limit, String line, String targetup) {
	ArrayList<MemberBean> MemberList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM member order by "+targetup+" "+line+" LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(2, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		MemberList = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean bb = new MemberBean();
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
			
			
			MemberList.add(bb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectMemberList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return MemberList;

}

public ArrayList<CarBean> selectCarListlinep(int page, int limit, String line, String targetup) {
ArrayList<CarBean> CarList = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		int startRow = (page - 1) * 10;
		
		String sql = "SELECT * FROM car order by "+targetup+" "+line+" LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow); // 시작 레코드 번호 전달
		pstmt.setInt(2, limit); // 게시물 수 전달
		rs = pstmt.executeQuery();
		
		CarList = new ArrayList<CarBean>();
		
		while(rs.next()) {
			CarBean cb =new CarBean();
			cb.setCar_num(rs.getString("car_num"));
			cb.setCar_id(rs.getInt("car_id"));
			cb.setCar_maker(rs.getString("car_maker"));
			cb.setCar_name(rs.getString("car_name"));
			cb.setCar_type(CAR_TYPE.values()[rs.getInt("car_type")].toString());
	
			
			CarList.add(cb);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectCarList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return CarList;
}

public MemberBean selectMemberBean(String id) {
	
	MemberBean bb = new MemberBean();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		String sql = "SELECT * FROM member where member_id=?";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		
		if(rs.next()) {
			bb.setMember_num(rs.getInt("member_num"));
			bb.setMember_name(rs.getString("member_name"));
			bb.setMember_id(rs.getString("member_id"));
			bb.setMember_pass(rs.getString("member_pass"));
			bb.setMember_email(rs.getString("member_email"));
			bb.setMember_age(rs.getString("member_age"));
			bb.setMember_gender(rs.getString("member_gender"));
			bb.setMember_tel(rs.getString("member_tel"));
			bb.setMember_adress(rs.getString("member_adress"));
			bb.setMember_license(rs.getString("member_license"));
			bb.setMember_smoke(rs.getString("member_smoke"));
			bb.setMember_pet(rs.getString("member_pet"));
			bb.setMember_boby(rs.getString("member_baby"));
			bb.setMember_grade(rs.getString("member_grade"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("AdminDAO - selectMemberList() 에러!"+e);
	} finally {
		
		close(rs); 
		close(pstmt);
	}
	
	return bb;
	
}


}

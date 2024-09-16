package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static info.db.jdbcutil.*;
import info.vo.ListBean;
import qna.dao.qnaBoardDAO;

public class mypageDAO {


private static mypageDAO instance;
	
	private mypageDAO() {}
	
	public static final mypageDAO getinstance() 
	{
		if(instance==null) 
		{
			instance=new mypageDAO();
		}
		
		return instance;
	}
	
//--------------------------------------------------------------------------------------------------
	
	Connection con;
	
	public void setCon(Connection con) 
	{
		this.con = con;
	}
	
//	------------------------------------------------------------------------------------------------
	
	public ListBean checkMember(String id) 
	{
		ListBean lb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			String sql = "select * from member where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				lb = new ListBean();
				lb.setId(rs.getString(2));
				lb.setPass(rs.getString(3));
				lb.setName(rs.getString(4));
				lb.setAge(rs.getString(5));
				lb.setGender(rs.getString(6));
				lb.setTel(rs.getString(7));
				lb.setAddress(rs.getString(8));
				lb.setEmail(rs.getString(9));
				lb.setLicense(rs.getString(10));
				lb.setSmoke(rs.getString(11));
				lb.setPet(rs.getString(12));
				lb.setBaby(rs.getString(13));
				lb.setGrade(rs.getString(14));
			}
			else
			{
				lb = null;
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
				rs.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return lb;
	}

	public ArrayList<ListBean> checkBook(String id, int page, int limit) {
		
		ArrayList<ListBean> list = new ArrayList<ListBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			int startrow=(page-1)*10;
			
			String sql = "select * from book where member_id=? order by book_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit); 
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				ListBean lb = new ListBean();
				lb.setBook_date(rs.getString(4));
				lb.setPickup_date(rs.getString(5));
				lb.setEnd_date(rs.getString(6));
				lb.setCar_id(rs.getInt(7));
				lb.setPrice(rs.getInt(8));
				list.add(lb);
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
				rs.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int getListCount(String id) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			String sql = "select count(*) from book where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
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
				rs.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return count;
	}

	public int infoUpdate(ListBean lb) {
		
		int check = 0;
		PreparedStatement pstmt = null;
		try 
		{
			String sql = "update member set member_pass=?, member_name=?, member_age=?, member_tel=? "
					+ ", member_license=? , member_smoke=? , member_pet=? , member_baby=? "
					+ "where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lb.getPass());
			pstmt.setString(2, lb.getName());
			pstmt.setString(3, lb.getAge());
			pstmt.setString(4, lb.getTel());
			pstmt.setString(5, lb.getLicense());
			pstmt.setString(6, lb.getSmoke());
			pstmt.setString(7, lb.getPet());
			pstmt.setString(8, lb.getBaby());
			pstmt.setString(9, lb.getId());
			check = pstmt.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return check;
	}

	public boolean checkDelete(String id, String pass) {
		
		boolean check = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			String sql = "select member_pass from member where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(pass))
				{
					check = true;
				}
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
				rs.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return check;
	}

	public int deletePro(String id) {
		
		PreparedStatement pstmt = null;
		int check = -1;
		
		try 
		{
			String sql = "delete from member where member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			check = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		return check;
	}
	
}



















package faq.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class jdbcutil {
	
	public static Connection getconnection() {
			Connection con=null;
			
			
			try {
				Context inictx=new InitialContext();
				DataSource ds=(DataSource)inictx.lookup("java:comp/env/jdbc/MySQL");

				

				con=ds.getConnection();


				con.setAutoCommit(false);
				
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return con;
	}
	
	
	
	public static void close(Connection con) {
		if(con!=null) {	try {con.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {	try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {	try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
	}
		
	

	

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}

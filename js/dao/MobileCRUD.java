package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.js.dto.Mobile;
import com.mysql.cj.protocol.Resultset;

public class MobileCRUD {
	
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://localhost:3306/jdbc_mobile";
	final static String user = "root";
	final static String password = "lavs";
	
	public static int insertMobile(Mobile m) {
		
		String query = "insert into mobile values(?,?,?,?)";
		Connection c = null;
		
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setDouble(4, m.getPrice());
			
			return ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	
	public static ArrayList<Mobile> getAllMobile(){
		ArrayList<Mobile> al = new ArrayList<Mobile>();
		String query = "select * from mobile";
		Connection c = null;
		
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mobile m = new Mobile();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getDouble(4));
				al.add(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
		
	}
	
	public static int deleteById(int id) {
		String query = "delete from mobile where id=?";
		Connection c = null;
		
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url , user , password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int UpdateMobileById(int id,Mobile m) {
		Connection  c = null;
		String query ="update mobile set name=?,brand=?,price=? where Id =?";
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setDouble(3, m.getPrice());
			ps.setInt(4, id);
			return ps .executeUpdate();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}

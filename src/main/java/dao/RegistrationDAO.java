package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Registration;
import entity.Room;

public class RegistrationDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public List<Registration> getAllRegistration(){
		String sql = "SELECT * FROM registration order by id";
		List<Registration> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Registration(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
	}
	
	public List<String> getAllBuoi(){
		String sql = "SELECT DISTINCT buoi FROM registration";
		List<String> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new String(rs.getString(1)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
	}
	
	public List<String> getAllNgay(){
		String sql = "SELECT DISTINCT ngaydangky FROM registration";
		List<String> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new String(rs.getString(1)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
	}
	
	public static void main(String[] args) {
		List<String> list = new RegistrationDAO().getAllBuoi();
		for(String o : list) {
			System.out.println(o);
		}
	}
}

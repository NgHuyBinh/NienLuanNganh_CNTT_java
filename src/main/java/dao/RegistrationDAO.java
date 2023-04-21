package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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
		String sql = "SELECT distinct ngaydangky FROM registration";
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
	
	public int getIdByRoomIdBuoiNgay(String room_id, String buoi, String ngaydangky) {
		
		String sql = "select id from registration where room_id= ? and buoi = ? and ngaydangky = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, room_id);
			ps.setString(2, buoi);
			ps.setString(3, ngaydangky);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	} 
	
	// thêm lịch phòng
	public void insertRegistration(int room_id, String ngaydangky, String buoi, int soluonghientai){
		String sql = "insert into registration (room_id,ngaydangky,buoi, soluonghientai) values (?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room_id);
			ps.setString(2, ngaydangky);
			ps.setString(3, buoi);
			ps.setInt(4, soluonghientai);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// xóa lịch phòng
	public void deleteRegistration(int id){
		String sql = "DELETE FROM registration WHERE id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		List<String> list = new RegistrationDAO().getAllNgay();
//		for(String o : list) {
//			System.out.println(o);
//		}
//		System.out.println(new RegistrationDAO().getIdByRoomIdBuoiNgay("2", "Sáng", "2023-04-25"));
		new RegistrationDAO().insertRegistration(2, "sddd", "chieu", 0);
		
	}
}

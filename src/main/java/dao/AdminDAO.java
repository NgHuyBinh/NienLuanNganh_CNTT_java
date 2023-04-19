package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Admin;
import entity.Student;

public class AdminDAO {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	public Admin checkAccount(String username, String password) {
		// kiem tra ham nay chua ?
		String sql = "select * from admin where username = ? and password = ?";
		try {
			conn = new DBContext().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new Admin(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public Admin getAdminByUsername(String username) {
		String sql = "select * from admin where username = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// lay thong tin admin theo id
	public Admin getAdminById(int id) {
		String sql = "SELECT * FROM admin where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Admin(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getIdByUsername(String username) {
		String sql = "SELECT id from admin where username = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		return 0;
	}
	public boolean checkPassword(String username, String password) {
		String sql = "select * from admin where username=? and password = ?";
		try {
			conn = new DBContext().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				return true;
				}
		}catch(Exception e) {
			e.printStackTrace();
			}
			return false;
	}
	// xử lý đăng ký
	
	
	public static void main (String[] args) {
//		System.out.println(new AdminDAO().getAdminById(3));
//		new AdminDAO().updatePassword("B1910191", "123");;
//		new AdminDAO().updateStudent("B1910191", "123", "Nguyễn Huy Bình", "2001-09-11", "Nam", "Lai Vung, Đồng Tháp", "Binhb1910191@student.ctu.edu.vn", "0123654879", 12, 2);
//		System.out.print(new AdminDAO().checkPassword("admin", "123"));
		System.out.print(new AdminDAO().getAdminByUsername("admin"));
	}
	
}

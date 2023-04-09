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

		String sql = "select * from admin where u = ? and password = ?";
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
}

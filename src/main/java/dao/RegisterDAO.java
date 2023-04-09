package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Register;

public class RegisterDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// ham dang ky
	public void getInsertRegister(int student_id,int registration_id,String trangthai,String ghichu) {
		String sql = "INSERT INTO Register(student_id, registration_id, trangthai, ghichu) VALUES (?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student_id);
			ps.setInt(2, registration_id);
			ps.setString(3, trangthai);
			ps.setString(4, ghichu);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// ham cap nhat dang ky
	public void updateRegister(int student_id, int registration_id, String trangthai, String ghichu) {
		String sql = "update register set student_id=?, registration_id=? ,trangthai=?,ghichu=? where student_id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student_id);
			ps.setInt(2, registration_id);
			ps.setString(3, trangthai);
			ps.setString(4, ghichu);
			ps.setInt(5, student_id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	//ham kiem tra id_student co ton tai ko
	public int checkStudentId(int student_id) {
		String sql = "select * from register where student_id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return student_id;
			}
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return 0;
	}
	public static void main (String[] args) {
		new RegisterDAO().updateRegister(7, 59, "0", "cập nhật");
		
	
	}
		
	 
}

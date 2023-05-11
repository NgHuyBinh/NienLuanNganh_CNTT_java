package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	// cập nhật lý do qua id
	
	//cập nhật ghi chú
	public void updateHuy( String ghichu,String trangthai, int id) {
		String sql = "update register set ghichu=?, trangthai=? where id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ghichu);
			ps.setString(2, trangthai);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	// hàm xác nhận duyet
	public void updateDuyet( String trangthai, int id) {
		String sql = "update register set  trangthai=? where id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, trangthai);
			ps.setInt(2, id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	public List<Register> getByStId(int id){
		String sql = "SELECT * from register where student_id=?";
			List<Register> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Register(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}return list;
	}
	public static void main (String[] args) {
	
		
	
	}
		
	 
}

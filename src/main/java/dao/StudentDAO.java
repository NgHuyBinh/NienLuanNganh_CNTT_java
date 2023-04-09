package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Student;
import entity.Student;


public class StudentDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// kiem tra tai khoan
	public Student checkAccount(String mssv, String password) {
		
		String sql = "select * from student where mssv = ? and password = ?";
		try {
			conn = new DBContext().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new Student(rs.getInt("id"),rs.getString("mssv"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"), rs.getString("class_id"),rs.getString("teacher_id") );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	// lay thong tin sinh vien theo id
	public Student getStudentById(int id) {
		String sql = "SELECT * FROM Student where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Student(rs.getInt("id"),rs.getString("mssv"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"), rs.getString("class_id"),rs.getString("teacher_id")  );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// lay thong tin sinh vien theo mssv
	public Student getStudentByMssv(String mssv) {
		String sql = "SELECT student.*,tenlop,teacher.hoten FROM student,class,teacher \r\n"
				+ "where teacher.id = student.teacher_id and student.class_id = class.id and mssv = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Student(rs.getInt("id"),rs.getString("mssv"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"), rs.getString("class_id"),rs.getString("teacher_id") );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getIdByMSSV(String mssv) {
		String sql = "SELECT id from student where mssv = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		return 0;
	}
	
	//check password
	public boolean checkPassword(String password, String mssv) {
		String sql = "select * from student where password = ? and mssv=?";
		try {
			conn = new DBContext().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, mssv);
			rs=ps.executeQuery();
			while(rs.next()) {
				return true;
				}
		}catch(Exception e) {
			e.printStackTrace();
			}
			return false;
	}
	
	// insert new password
	public void updatePassword(String mssv, String password) {
		String sql =  "update student set password=? where mssv=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, mssv);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// update password
	public void updateStudent(String mssv, String password, String hoten, String ngaysinh, String gioitinh, String diachi, String email, String sdt, int class_id, int teacher_id) {
		String sql = "update student set mssv=?, password=? ,hoten=?,ngaysinh=?, gioitinh=?, diachi=?, email=? , sdt=? , class_id=? , teacher_id=? where mssv=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			ps.setString(2, password);
			ps.setString(3, hoten);
			ps.setString(4, ngaysinh);
			ps.setString(5, gioitinh);
			ps.setString(6, diachi);
			ps.setString(7, email);
			ps.setString(8, sdt);
			ps.setInt(9, class_id);
			ps.setInt(10, teacher_id);
			ps.setString(11, mssv);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
//		System.out.println(new StudentDAO().getStudentById(1));
//		new StudentDAO().updatePassword("B1910191", "123");;
//		new StudentDAO().updateStudent("B1910191", "123", "Nguyễn Huy Bình", "2001-09-11", "Nam", "Lai Vung, Đồng Tháp", "Binhb1910191@student.ctu.edu.vn", "0123654879", 12, 2);
		System.out.print(new StudentDAO().checkPassword("123", "B1910191"));
	}
}

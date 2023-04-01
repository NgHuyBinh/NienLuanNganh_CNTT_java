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
	public static void main (String[] args) {
//		System.out.println(new StudentDAO().getStudentById(1));
		System.out.println(new StudentDAO().getStudentByMssv("B1910191"));
	}
}

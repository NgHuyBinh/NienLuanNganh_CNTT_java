package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Class;
import entity.Student;
import entity.Teacher;

public class TeacherDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Teacher getTeacherById(int id) {
		String sql = "SELECT * FROM teacher where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Teacher(rs.getInt("id"),rs.getString("magv"),rs.getString("password"),rs.getString("hoten"),rs.getString("ngaysinh"),rs.getString("gioitinh"),rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main (String[] args) {
//		System.out.println(new StudentDAO().getStudentById(1));
		System.out.println(new TeacherDAO().getTeacherById(1));
	}
}

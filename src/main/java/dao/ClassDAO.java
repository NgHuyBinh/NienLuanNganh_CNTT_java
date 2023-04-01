package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Class;
import entity.Student;

public class ClassDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Class getClassById(int id) {
		String sql = "SELECT * FROM class where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Class(rs.getInt("id"),rs.getString("malop"),rs.getString("tenlop"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main (String[] args) {
//		System.out.println(new StudentDAO().getStudentById(1));
		System.out.println(new ClassDAO().getClassById(11));
	}
}

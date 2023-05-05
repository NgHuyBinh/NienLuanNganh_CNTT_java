package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class RegisterroomDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertRegisterRoom(int student_id, String ngaydangky){
		String sql = "insert into registerroom (student_id, ngaydangky) values (?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student_id);
			ps.setString(2, ngaydangky);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

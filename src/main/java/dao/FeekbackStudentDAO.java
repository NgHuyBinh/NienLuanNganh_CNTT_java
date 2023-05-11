package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class FeekbackStudentDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertFeekback(String noidung, String ngayphanhoi, int student_id, int room_id, String trangthai, String ghichu) {
		String sql = "insert into feedback (noidung,ngayphanhoi,student_id,room_id,trangthai,ghichu) values (?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, noidung);
			ps.setString(2, ngayphanhoi);
			ps.setInt(3, student_id);
			ps.setInt(4, room_id);
			ps.setString(5, trangthai);
			ps.setString(6, ghichu);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FeekbackStudentDAO().insertFeekback("máy chiếu hư", "2023-2-22 00:00:00:00", 7, 5, "2","không" );
	}
	// cập nhật nội dung phản hồi
	
}

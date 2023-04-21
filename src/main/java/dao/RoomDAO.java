package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Room;

public class RoomDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public List<Room> getAllRoom(){
		String sql = "SELECT * FROM room order by id";
		List<Room> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Room(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
	}
	// thêm phòng
	public void insertRoom(String phong, int soluongtoida){
		String sql = "insert into room (phong,soluongtoida) values (?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phong);
			ps.setInt(2, soluongtoida);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// xóa phòng
	public void deleteRoomById(int id){
		String sql = "DELETE FROM room WHERE id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		List<Room> list = new RoomDAO().getAllRoom();
//		for(Room o : list) {
//			System.out.println(o);
//		}
		
		new RoomDAO().deleteRoomById(8);
	}
}

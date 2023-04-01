package entity;

public class Room {
	private int id;
	private String phong, soluongtoida;

	public Room(int id, String phong, String soluongtoida) {
		super();
		this.id = id;
		this.phong = phong;
		this.soluongtoida = soluongtoida;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoluongtoida() {
		return soluongtoida;
	}
	public void setSoluongtoida(String soluongtoida) {
		this.soluongtoida = soluongtoida;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", " + (soluongtoida != null ? "soluongtoida=" + soluongtoida + ", " : "")
				+ (phong != null ? "phong=" + phong : "") + "]";
	}
	
	
}

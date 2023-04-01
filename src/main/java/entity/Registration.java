package entity;

public class Registration {
	private int id, room_id;
	private String  ngaydangky, buoi;
	private int songuoihientai;
	public Registration(int id, int room_id, String ngaydangky, String buoi, int songuoihientai) {
		super();
		this.id = id;
		this.room_id = room_id;
		this.ngaydangky = ngaydangky;
		this.buoi = buoi;
		this.songuoihientai = songuoihientai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	public String getBuoi() {
		return buoi;
	}
	public void setBuoi(String buoi) {
		this.buoi = buoi;
	}
	public int getSonguoihientai() {
		return songuoihientai;
	}
	public void setSonguoihientai(int songuoihientai) {
		this.songuoihientai = songuoihientai;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", room_id=" + room_id + ", "
				+ (ngaydangky != null ? "ngaydangky=" + ngaydangky + ", " : "")
				+ (buoi != null ? "buoi=" + buoi + ", " : "") + "songuoihientai=" + songuoihientai + "]";
	}
	
	
	
}

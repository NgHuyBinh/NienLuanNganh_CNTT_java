package entity;

public class Feedback {
	private int id;
	private String noidung, ngayphanhoi, student_id, room_id, trangthai, ghichu;
	public Feedback(int id, String noidung, String ngayphanhoi, String student_id, String room_id, String trangthai,
			String ghichu) {
		super();
		this.id = id;
		this.noidung = noidung;
		this.ngayphanhoi = ngayphanhoi;
		this.student_id = student_id;
		this.room_id = room_id;
		this.trangthai = trangthai;
		this.ghichu = ghichu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNgayphanhoi() {
		return ngayphanhoi;
	}
	public void setNgayphanhoi(String ngayphanhoi) {
		this.ngayphanhoi = ngayphanhoi;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", " + (noidung != null ? "noidung=" + noidung + ", " : "")
				+ (ngayphanhoi != null ? "ngayphanhoi=" + ngayphanhoi + ", " : "")
				+ (student_id != null ? "student_id=" + student_id + ", " : "")
				+ (room_id != null ? "room_id=" + room_id + ", " : "")
				+ (trangthai != null ? "trangthai=" + trangthai + ", " : "")
				+ (ghichu != null ? "ghichu=" + ghichu : "") + "]";
	}
	
	
}

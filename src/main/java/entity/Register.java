package entity;

public class Register {
	@Override
	public String toString() {
		return "Register [id=" + id + ", " + (student_id != null ? "student_id=" + student_id + ", " : "")
				+ (registration_id != null ? "registration_id=" + registration_id + ", " : "")
				+ (trangthai != null ? "trangthai=" + trangthai + ", " : "")
				+ (ghichu != null ? "ghichu=" + ghichu : "") + "]";
	}
	private int id;
	private String student_id, registration_id,trangthai,ghichu;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int id, String student_id, String registration_id, String trangthai, String ghichu) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.registration_id = registration_id;
		this.trangthai = trangthai;
		this.ghichu = ghichu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(String registration_id) {
		this.registration_id = registration_id;
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
	
	
}

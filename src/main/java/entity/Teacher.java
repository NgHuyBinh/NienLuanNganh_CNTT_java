package entity;

public class Teacher {
	private int id;
	private String magv, password,  hoten,  ngaysinh,  gioitinh, diachi, email, sdt;
	public Teacher(int id, String magv, String password, String hoten, String ngaysinh, String gioitinh, String diachi,
			String email, String sdt) {
		super();
		this.id = id;
		this.magv = magv;
		this.password = password;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.email = email;
		this.sdt = sdt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMagv() {
		return magv;
	}
	public void setMagv(String magv) {
		this.magv = magv;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", " + (magv != null ? "magv=" + magv + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (hoten != null ? "hoten=" + hoten + ", " : "")
				+ (ngaysinh != null ? "ngaysinh=" + ngaysinh + ", " : "")
				+ (gioitinh != null ? "gioitinh=" + gioitinh + ", " : "")
				+ (diachi != null ? "diachi=" + diachi + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (sdt != null ? "sdt=" + sdt : "") + "]";
	}
	
	
}

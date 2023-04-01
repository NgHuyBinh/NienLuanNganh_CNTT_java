package entity;

public class Admin {
	private int id;
	private String username, password, hoten, ngaysinh, gioitinh, diachi, email,sdt;
	public Admin(int id, String username, String password, String hoten, String ngaysinh, String gioitinh,
			String diachi, String email, String sdt) {
		super();
		this.id = id;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "admin [id=" + id + ", " + (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (hoten != null ? "hoten=" + hoten + ", " : "")
				+ (ngaysinh != null ? "ngaysinh=" + ngaysinh + ", " : "")
				+ (gioitinh != null ? "gioitinh=" + gioitinh + ", " : "")
				+ (diachi != null ? "diachi=" + diachi + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (sdt != null ? "sdt=" + sdt : "") + "]";
	}
	
	
}

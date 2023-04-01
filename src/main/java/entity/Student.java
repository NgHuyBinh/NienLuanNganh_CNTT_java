package entity;

public class Student {
	private int id;
	private String mssv, password,  hoten,  ngaysinh,  gioitinh, diachi, email, sdt, class_id, teacher_id;
	public Student() {
		super();
	}
	
	
	public Student(int id, String mssv, String password, String hoten, String ngaysinh, String gioitinh, String diachi,
			String email, String sdt, String class_id, String teacher_id) {
		super();
		this.id = id;
		this.mssv = mssv;
		this.password = password;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.email = email;
		this.sdt = sdt;
		this.class_id = class_id;
		this.teacher_id = teacher_id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
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

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", mssv=" + mssv + ", password=" + password + ", hoten=" + hoten + ", ngaysinh="
				+ ngaysinh + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", email=" + email + ", sdt=" + sdt
				+ ", class_id=" + class_id + ", teacher_id=" + teacher_id + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}

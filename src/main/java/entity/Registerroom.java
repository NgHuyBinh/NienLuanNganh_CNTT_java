package entity;

public class Registerroom {
	private int id, student_id;
	private String ngaydangky;
	public Registerroom(int id, int student_id, String ngaydangky) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.ngaydangky = ngaydangky;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	@Override
	public String toString() {
		return "Registerroom [id=" + id + ", student_id=" + student_id + ", "
				+ (ngaydangky != null ? "ngaydangky=" + ngaydangky : "") + "]";
	}
	
	
}

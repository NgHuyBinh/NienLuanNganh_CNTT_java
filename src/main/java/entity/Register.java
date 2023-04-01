package entity;

public class Register {
	private int id;
	private String student_id, registration_id;
	public Register(int id, String student_id, String registration_id) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.registration_id = registration_id;
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
	@Override
	public String toString() {
		return "Register [id=" + id + ", " + (student_id != null ? "student_id=" + student_id + ", " : "")
				+ (registration_id != null ? "registration_id=" + registration_id : "") + "]";
	}
	
	
}

package entity;

public class Class {
	private int id;
	private String malop, tenlop;

	public Class(int id, String malop, String tenlop) {
		super();
		this.id = id;
		this.malop = malop;
		this.tenlop = tenlop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", " + (malop != null ? "malop=" + malop + ", " : "")
				+ (tenlop != null ? "tenlop=" + tenlop : "") + "]";
	}
	
	
	

}

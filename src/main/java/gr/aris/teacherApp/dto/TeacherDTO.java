package gr.aris.teacherApp.dto;

public class TeacherDTO {
	private int id;
	private String fname;
	private String sname;
	
	private String email;
	
	private String password;
	
	public TeacherDTO() {}
	
	



	public TeacherDTO(int id, String fname, String sname, String email, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.sname = sname;
		this.email = email;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}

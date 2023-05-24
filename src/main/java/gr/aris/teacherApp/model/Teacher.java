package gr.aris.teacherApp.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Teacher POJO class. 
 * 
 * @author A. Androutsos
 *
 */
@Entity
@Table(name="Teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEACHER_ID")
	private int id;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="FIRST_NAME")
	private String fname;
	@Column(name="LAST_NAME")
	private String sname;
	
	
	
	public Teacher() {}
	
	

	public Teacher(int id, String email, String password, String fname, String sname) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.sname = sname;
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Teacher [id=" + id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", sname="
				+ sname + "]";
	}

	
}

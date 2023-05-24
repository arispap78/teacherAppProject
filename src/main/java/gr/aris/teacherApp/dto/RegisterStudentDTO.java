package gr.aris.teacherApp.dto;

//import javax.validation.constraints.Email;

public class RegisterStudentDTO {
	//@Email
	private String email;
	private String password;
	private String confirmPassword;
	private String lastname;
	private String firstname;
	
	public RegisterStudentDTO() {
	}

	public RegisterStudentDTO(String email, String password, 
			String confirmPassword, String lastname, String firstname) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	// Setters, Getters
	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	

}

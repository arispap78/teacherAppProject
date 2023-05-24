package gr.aris.teacherApp.dto;

public class StudentCourseDTO {
	
	private String courseId;
	private Long studentId;
	
	public StudentCourseDTO() {}
	
	public StudentCourseDTO(String courseId, 
			Long studentId) {
		this.courseId = courseId;
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
}

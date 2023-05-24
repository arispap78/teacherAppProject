package gr.aris.teacherApp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

public interface ITeacherDAO {
	void insert(Teacher teacher) throws SQLException;
	void delete(Teacher teacher) throws SQLException;
	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
	List<Teacher> getTeachersBySurname(String surname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException, TeacherNotFoundException;
	ArrayList<Teacher> getAllTeachers() throws SQLException;
	public Teacher getTeacherByEmail(String email,String password) throws SQLException;
}

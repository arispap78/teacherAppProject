package gr.aris.teacherApp.dao;

import static gr.aris.teacherApp.dao.dbutil.DBUtil.closeConnection;
import static gr.aris.teacherApp.dao.dbutil.DBUtil.openConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO TEACHER VALUES ('" + teacher.getId() 
		+ "', '" + teacher.getEmail() + "', '" + teacher.getFname() + "', '" + teacher.getPassword() + "','" + teacher.getSname() + "')";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		int n = pst.executeUpdate(sql);
		
		pst.close();
		closeConnection();
	}

	@Override
	public void delete(Teacher teacher) throws SQLException {
		String sql = "DELETE FROM TEACHER WHERE TEACHER_ID = " + teacher.getId();

		
		PreparedStatement pst = openConnection().prepareStatement(sql);
	
      	int numberOfRowsAffected = pst.executeUpdate();

      	pst.close();
      	closeConnection();
	}

	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		String sql = "UPDATE TEACHER SET EMAIL = '" + newTeacher.getEmail() + "', " + "FIRST_NAME = '" 
				+ newTeacher.getFname() + "', "+"PASSWORD = '" + newTeacher.getPassword() + "', " +"LAST_NAME = '" + 
				newTeacher.getSname() +  "' WHERE TEACHER_ID = " + oldTeacher.getId();
		System.out.println(sql);
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		int numberOfRowsAffected = pst.executeUpdate();
	      
		  pst.close();
		  closeConnection();
	}

	@Override
	public List<Teacher> getTeachersBySurname(String surname) throws SQLException {
		String sql = "SELECT TEACHER_ID, LAST_NAME, FIRST_NAME, PASSWORD, EMAIL FROM TEACHER WHERE LAST_NAME LIKE '" 
				+ surname + "%'";
		
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    List<Teacher> teachers = new ArrayList<>();
	    
	    //rs.beforeFirst();
	    while (rs.next()) {
	    	Teacher teacher = new Teacher();
		    	
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("LAST_NAME"));
	    	teacher.setFname(rs.getString("FIRST_NAME"));
	    	teacher.setEmail(rs.getString("EMAIL"));
	    	teacher.setPassword(rs.getString("PASSWORD"));
	    	teachers.add(teacher); 	
	    }
	    
	    closeConnection();
	    return teachers;
	}
	@Override
	public ArrayList<Teacher> getAllTeachers() throws SQLException {
		String sql = "SELECT * FROM TEACHER " ;
		
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    ArrayList<Teacher> teachers = new ArrayList<>();
	    
	    while (rs.next()) {
	    	Teacher teacher = new Teacher();
		    	
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("LAST_NAME"));
	    	teacher.setFname(rs.getString("FIRST_NAME"));
	    	teacher.setEmail(rs.getString("EMAIL"));
	    	teacher.setPassword(rs.getString("PASSWORD"));
	    	teachers.add(teacher); 	
	    }
	    closeConnection();
	    return teachers;
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException,TeacherNotFoundException {
		String sql = "SELECT * FROM TEACHER WHERE TEACHER_ID = " 
				+ id;
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    Teacher teacher = new Teacher();
	    if (rs.next()) {
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("LAST_NAME"));
	    	teacher.setFname(rs.getString("FIRST_NAME"));
	    	teacher.setEmail(rs.getString("EMAIL"));
	    	teacher.setPassword(rs.getString("PASSWORD"));
	    	return teacher;
	    }
	    
	    return null;
	}	

	public Teacher getTeacherByEmail(String email,String password) throws SQLException {
		String sql = "SELECT * FROM TEACHER WHERE EMAIL LIKE '" + email + "%'"+" AND PASSWORD = "+ password;
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    Teacher teacher = new Teacher();
	    if (rs.next()) {
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("LAST_NAME"));
	    	teacher.setFname(rs.getString("FIRST_NAME"));
	    	teacher.setEmail(rs.getString("EMAIL"));
	    	teacher.setPassword(rs.getString("PASSWORD"));
	    	return teacher;
	    }
	    
	    return null;
	}	
}



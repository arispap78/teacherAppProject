package gr.aris.teacherApp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aris.teacherApp.dao.*;
import gr.aris.teacherApp.dto.TeacherDTO;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.exceptions.TeacherIdAlreadyExistsException;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImpl implements ITeacherService {
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void insertTeacher(TeacherDTO teacherDTO) 
			throws TeacherIdAlreadyExistsException, SQLException 
	{
		
		Teacher newTeacher = new Teacher();
		//newTeacher.setId(teacherDTO.getId());
		newTeacher.setSname(teacherDTO.getSname());
		newTeacher.setFname(teacherDTO.getFname());
		newTeacher.setEmail(teacherDTO.getEmail());
		newTeacher.setPassword(teacherDTO.getPassword());
		System.out.println("nan");
		
		try 
		{
			if ((teacherDAO.getTeacherById(newTeacher.getId())) == null) 
			{
				teacherDAO.insert(newTeacher);
			}
		} 
		catch (SQLException | TeacherNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) throws TeacherNotFoundException, SQLException {
		Teacher teacherToDelete = new Teacher();
		teacherToDelete.setId(teacherDTO.getId());
		
		if ((teacherDAO.getTeacherById(teacherToDelete.getId())) == null) 
			throw new TeacherNotFoundException(teacherToDelete);
		teacherDAO.delete(teacherToDelete);
		
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws TeacherNotFoundException, SQLException {
		Teacher teacherToUpdate = new Teacher();
		teacherToUpdate.setId(oldTeacherDTO.getId());
		
		Teacher newTeacher = new Teacher();
		newTeacher.setId(newTeacherDTO.getId());
		newTeacher.setSname(newTeacherDTO.getSname());
		newTeacher.setFname(newTeacherDTO.getFname());	
		newTeacher.setEmail(newTeacherDTO.getEmail());
		newTeacher.setPassword(newTeacherDTO.getPassword());
		
		if ((teacherDAO.getTeacherById(teacherToUpdate.getId())) == null) 
			throw new TeacherNotFoundException(teacherToUpdate);
		teacherDAO.update(teacherToUpdate, newTeacher);
		
	}

	@Override
	public List<Teacher> getTeachersBySurname(String surname) throws SQLException {	
		return teacherDAO.getTeachersBySurname(surname);
	}
	
	public Teacher getTeachersById(String Id)throws SQLException,TeacherNotFoundException{
		try 
		{
			int id=Integer.parseInt(Id);
			return teacherDAO.getTeacherById(id);		
			
		} catch (SQLException  e) {		
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public ArrayList<Teacher> getAllTeachers() {	
		try 
		{
			return teacherDAO.getAllTeachers();		
			
		} catch (SQLException  e) {		
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Teacher getTeachersByEmail(String email,String password)throws SQLException{
		try 
		{
			return teacherDAO.getTeacherByEmail(email,password);		
			
		} catch (SQLException  e) {		
			System.out.println(e.getMessage());
		}
		return null;
	}
}

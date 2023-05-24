package gr.aris.teacherApp.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gr.aris.teacherApp.dao.ITeacherDAO;
import gr.aris.teacherApp.dao.TeacherDAOImpl;
import gr.aris.teacherApp.dto.TeacherDTO;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.ITeacherService;
import gr.aris.teacherApp.service.TeacherServiceImpl;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

@Controller
public class UpdateController 
{
	
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);


	
	  @GetMapping("/teacherList/edit/{id}") 
	  public String editStudentForm(@PathVariable String id, Model model) 
	  { 
		  try 
		  {
			model.addAttribute("teacher",teacherService.getTeachersById(id));
		  } 
		  catch (SQLException | TeacherNotFoundException e) 
		  {
			e.printStackTrace();
		  } 
		  return "EditTeacher.html";
	  }
	  
	
	
	  @PostMapping("/teacherList/{id}")
	  public String updateStudent(@PathVariable String id,@ModelAttribute("teacher") Teacher newTeacher, Model model) 
	  {
	  
	  try { 
		  teacherDAO.update(newTeacher, newTeacher); 
		  }
	  
	  catch (SQLException e) 
	  	  {
		  e.printStackTrace(); 
		  } 
	  return "redirect:/teacherList"; 
	  }
	
}

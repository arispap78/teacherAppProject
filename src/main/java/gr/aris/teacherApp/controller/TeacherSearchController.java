package gr.aris.teacherApp.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.aris.teacherApp.dao.ITeacherDAO;
import gr.aris.teacherApp.dao.TeacherDAOImpl;
import gr.aris.teacherApp.service.ITeacherService;
import gr.aris.teacherApp.service.TeacherServiceImpl;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

@Controller
public class TeacherSearchController 
{
	
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
	
	
	
	  @GetMapping("/teacherSearch") 
	  public String searchTeachers(Model model) 
	  { 
		  return "teacherSearch.html"; 
	  }
	  
	  
	  
	  	@PostMapping("/teacherSearch")
		public String searchTeacher(@RequestParam String teacherId,Model model) 
		{
			try 
			{
				if(teacherService.getTeachersById(teacherId)!=null) 
				{
					model.addAttribute("teacher",teacherService.getTeachersById(teacherId));

				}
				else 
				{
					return "teacherNoFound.html";
				}
			} 
			catch (SQLException | TeacherNotFoundException e) 
			{
				e.printStackTrace();
			}
			return "teacherFound.html";
		}
	  	
	  	@PostMapping("/teacherSearch/surname")
		public String searchTeachers(@RequestParam String surname,Model model) 
		{
			try 
			{
				if(teacherService.getTeachersBySurname(surname)!=null) 
				{
					model.addAttribute("teachers",teacherService.getTeachersBySurname(surname));

				}
				else 
				{
					return "teacherNoFound.html";
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return "teachersFound.html";
		}

}

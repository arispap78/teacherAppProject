package gr.aris.teacherApp.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.aris.teacherApp.dao.ITeacherDAO;
import gr.aris.teacherApp.dao.TeacherDAOImpl;
import gr.aris.teacherApp.dto.TeacherDTO;
import gr.aris.teacherApp.service.ITeacherService;
import gr.aris.teacherApp.service.TeacherServiceImpl;
import gr.aris.teacherApp.service.exceptions.TeacherIdAlreadyExistsException;

@Controller
public class RegisterController {
	
	
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
	
	//private TeacherDTO teacherDTO=new TeacherDTO();
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("teacherForm", new TeacherDTO());
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("teacherForm") TeacherDTO teacherDTO) 
	{
		try 
		{
			teacherService.insertTeacher(teacherDTO);
		} 
		catch (TeacherIdAlreadyExistsException | SQLException e) 
		{
			e.printStackTrace();
		}
		return "redirect:/teacherList";
	}
	
	@GetMapping("/login")
	public String login(Model model) 
	{
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password,Model model) 
	{
		try 
		{
			if(teacherService.getTeachersByEmail(email,password)!=null) 
			{
				model.addAttribute("teacher",teacherService.getTeachersByEmail(email,password));
			}
			else
				return "teacherNoFound.html";
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		return "teacherFound.html";
	}
	
}

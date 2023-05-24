package gr.aris.teacherApp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gr.aris.teacherApp.dao.ITeacherDAO;
import gr.aris.teacherApp.dao.TeacherDAOImpl;
import gr.aris.teacherApp.dto.TeacherDTO;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.ITeacherService;
import gr.aris.teacherApp.service.TeacherServiceImpl;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

@Controller
public class TeacherShowController {
	

	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
	
	@GetMapping("/teacherList")
	public String ListTeachers(Model model) throws SQLException 
	{
		model.addAttribute("teachers",teacherService.getAllTeachers());
		
		return "teacherList.html";
	}
}

package gr.aris.teacherApp.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import gr.aris.teacherApp.dao.ITeacherDAO;
import gr.aris.teacherApp.dao.TeacherDAOImpl;
import gr.aris.teacherApp.model.Teacher;
import gr.aris.teacherApp.service.ITeacherService;
import gr.aris.teacherApp.service.TeacherServiceImpl;
import gr.aris.teacherApp.service.exceptions.TeacherNotFoundException;

@Controller
public class DeleteController 
{
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);

	@GetMapping("/teacherList/{id}")
	public String deleteStudent(@PathVariable String id/*, Model model*/) throws SQLException, TeacherNotFoundException 
	{
		/*model.addAttribute("teacher", */Teacher teacher=teacherService.getTeachersById(id);
		try {
			teacherDAO.delete(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/teacherList";
		}
}

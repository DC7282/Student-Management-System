package com.dhiraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dhiraj.entity.Student;
import com.dhiraj.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
//	we use handler method to handle list student and return model and view
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/add_new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "add_new_student";
	}
	
	@PostMapping("/addstudents")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model) {
		
//		Get student from database by id
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
//		existingStudent.setEmail(student.getEmail());  we don't update this field and it is not null property
		existingStudent.setContact(student.getContact());
//		existingStudent.setPassword(student.getPassword());  we don't update this field and it is not null property
		
//		save update student object
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
